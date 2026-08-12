package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Clase: UsuarioService

Implementa el puerto de entrada con una lista temporal en memoria. Esta es una
version de aprendizaje: el resto de la aplicacion conoce el contrato y no el
ArrayList, por lo que despues puede cambiarse por MySQL sin cambiar el dominio.
-------------------------------------------------------
*/
public class UsuarioService implements UsuarioUseCase {
    // List es el contrato de coleccion; ArrayList es su implementacion concreta.
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario registrar(String username, String email) {
        boolean existe = usuarios.stream()
                .anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
        if (existe) {
            throw new IllegalStateException("Ya existe un usuario con ese username.");
        }
        Usuario nuevo = new Usuario(username, email);
        usuarios.add(nuevo);
        return nuevo;
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public List<Usuario> listarActivos() {
        return usuarios.stream()
                .filter(Usuario::isActivo)
                .toList();
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
    }
}
