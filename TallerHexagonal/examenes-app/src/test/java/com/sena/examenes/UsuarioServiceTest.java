package com.sena.examenes;

import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.application.service.UsuarioService;
import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
-------------------------------------------------------
Clase: UsuarioServiceTest

Prueba el servicio sin Spring, MySQL ni JPA. UsuarioRepositoryPortFalso es un
test double: cumple el mismo contrato que el adaptador real, pero guarda en
una lista temporal. Esto demuestra que la logica de aplicacion esta aislada.
-------------------------------------------------------
*/
class UsuarioServiceTest {
    @Test
    void noPermiteRegistrarUsernameDuplicado() {
        UsuarioService service = new UsuarioService(new UsuarioRepositoryPortFalso(),
                new RolRepositoryPortFalso());
        service.registrar("cbarrientos", "cbarrientos@sena.edu.co");

        assertThrows(IllegalStateException.class, () ->
                service.registrar("cbarrientos", "otro@correo.com"));
    }

    @Test
    void desactivarActualizaElUsuarioYLoRetiraDeActivos() {
        UsuarioRepositoryPortFalso repositorio = new UsuarioRepositoryPortFalso();
        UsuarioService service = new UsuarioService(repositorio, new RolRepositoryPortFalso());
        service.registrar("lgomez", "lgomez@sena.edu.co");

        service.desactivarUsuario("lgomez");

        assertFalse(service.buscarPorUsername("lgomez").orElseThrow().isActivo());
        assertTrue(service.listarActivos().isEmpty());
    }

    @Test
    void asignarRolNoDuplicaElMismoRol() {
        UsuarioRepositoryPortFalso usuarios = new UsuarioRepositoryPortFalso();
        RolRepositoryPortFalso roles = new RolRepositoryPortFalso();
        UsuarioService service = new UsuarioService(usuarios, roles);
        service.registrar("lgomez", "lgomez@sena.edu.co");
        roles.guardar(new Rol("ADMIN", "Administracion"));

        service.asignarRol("lgomez", "ADMIN");
        service.asignarRol("lgomez", "admin");

        assertTrue(service.buscarPorUsername("lgomez").orElseThrow().tieneRol("ADMIN"));
        assertTrue(service.buscarPorUsername("lgomez").orElseThrow().getRoles().size() == 1);
    }

    private static class UsuarioRepositoryPortFalso implements UsuarioRepositoryPort {
        private final List<Usuario> datos = new ArrayList<>();

        @Override
        public Usuario guardar(Usuario usuario) {
            datos.removeIf(actual -> actual.getUsername().equalsIgnoreCase(usuario.getUsername()));
            datos.add(usuario);
            return usuario;
        }

        @Override
        public Optional<Usuario> buscarPorUsername(String username) {
            return datos.stream()
                    .filter(u -> u.getUsername().equalsIgnoreCase(username))
                    .findFirst();
        }

        @Override
        public List<Usuario> listarActivos() {
            return datos.stream().filter(Usuario::isActivo).toList();
        }

        @Override
        public boolean existePorUsername(String username) {
            return buscarPorUsername(username).isPresent();
        }
    }

    private static class RolRepositoryPortFalso implements RolRepositoryPort {
        private final List<Rol> datos = new ArrayList<>();

        @Override
        public Rol guardar(Rol rol) { datos.add(rol); return rol; }

        @Override
        public Optional<Rol> buscarPorNombre(String nombre) {
            return datos.stream().filter(r -> r.getNombre().equalsIgnoreCase(nombre)).findFirst();
        }

        @Override
        public List<Rol> listarTodos() { return List.copyOf(datos); }
    }
}
