package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/*
-------------------------------------------------------
Clase: UsuarioService

Implementa el puerto de entrada con una lista temporal en memoria. Esta es una
version de aprendizaje: el resto de la aplicacion conoce el contrato y no el
ArrayList, por lo que despues puede cambiarse por MySQL sin cambiar el dominio.
-------------------------------------------------------
*/
@Service
public class UsuarioService implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
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
}
