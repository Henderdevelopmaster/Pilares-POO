package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import com.sena.examenes.domain.Rol;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

/*
-------------------------------------------------------
Clase: UsuarioService

Implementa el puerto de entrada y coordina los puertos de salida de usuarios y
roles. La infraestructura concreta queda fuera: el servicio solo conoce
interfaces y por eso conserva la independencia de la arquitectura hexagonal.
-------------------------------------------------------
*/
@Service
public class UsuarioService implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final RolRepositoryPort rolRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort,
                           RolRepositoryPort rolRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.rolRepositoryPort = rolRepositoryPort;
    }

    @Override
    public Usuario registrar(String username, String email) {
        if (usuarioRepositoryPort.existePorUsername(username)) {
            throw new IllegalStateException("Ya existe un usuario con ese username.");
        }
        Usuario nuevo = new Usuario(username, email);
        return usuarioRepositoryPort.guardar(nuevo);
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepositoryPort.buscarPorUsername(username);
    }

    @Override
    public List<Usuario> listarActivos() {
        return usuarioRepositoryPort.listarActivos();
    }

    /*
    Reto de andamiaje: reutiliza buscarPorUsername para no duplicar la regla
    de consulta. Si no existe, la operacion no puede realizarse y se lanza una
    IllegalArgumentException con un mensaje claro.
    */
    @Override
    public void desactivarUsuario(String username) {
        Usuario usuario = buscarPorUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe un usuario con ese username."));
        usuario.desactivar();
        usuarioRepositoryPort.guardar(usuario);
    }

    /*
    Coordina dos agregados a traves de dos puertos OUT. Primero valida que
    existan usuario y rol; luego el dominio asigna el rol y guardar persiste
    el usuario actualizado. No se deja esta validacion al mapper porque alli
    ya seria un detalle de infraestructura y no produciria un 404 claro.
    */
    @Override
    public Usuario asignarRol(String username, String nombreRol) {
        Usuario usuario = usuarioRepositoryPort.buscarPorUsername(username)
                .orElseThrow(() -> new NoSuchElementException(
                        "No existe un usuario con ese username."));
        Rol rol = rolRepositoryPort.buscarPorNombre(nombreRol)
                .orElseThrow(() -> new NoSuchElementException(
                        "No existe un rol con ese nombre."));
        usuario.asignarRol(rol);
        return usuarioRepositoryPort.guardar(usuario);
    }
}
