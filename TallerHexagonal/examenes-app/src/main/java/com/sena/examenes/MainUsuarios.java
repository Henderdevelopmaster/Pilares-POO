package com.sena.examenes;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.application.service.UsuarioService;
import com.sena.examenes.domain.Usuario;
import com.sena.examenes.domain.Rol;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Clase: MainUsuarios

Prueba la Sesion 1 sin iniciar Spring. La variable se declara como el puerto
de entrada, no como una lista ni como un detalle de persistencia: ese es el
limite visible para quien usa el sistema.
-------------------------------------------------------
*/
public class MainUsuarios {
    public static void main(String[] args) {
        // En la Sesion 2 el servicio recibe el puerto OUT por constructor.
        // Este adaptador falso permite conservar una prueba de consola sin MySQL.
        UsuarioUseCase usuarioUseCase = new UsuarioService(
                new RepositorioEnMemoria(), new RolesEnMemoria());
        usuarioUseCase.registrar("cbarrientos", "cbarrientos@sena.edu.co", "clave1");
        usuarioUseCase.registrar("lgomez", "lgomez@sena.edu.co", "clave2");

        try {
            usuarioUseCase.registrar("cbarrientos", "otro@correo.com", "clave3");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        usuarioUseCase.buscarPorUsername("lgomez")
                .ifPresent(u -> System.out.println("Encontrado: " + u.getEmail()));

        // El reto desactiva un usuario y demuestra que ya no aparece entre activos.
        usuarioUseCase.desactivarUsuario("lgomez");
        int totalActivos = usuarioUseCase.listarActivos().size();
        System.out.println("Usuarios activos despues de desactivar: " + totalActivos);

        try {
            usuarioUseCase.desactivarUsuario("noexiste");
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }

    /* Adaptador local de prueba: cumple el puerto OUT sin depender de Spring. */
    private static class RepositorioEnMemoria implements UsuarioRepositoryPort {
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

    private static class RolesEnMemoria implements RolRepositoryPort {
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
