package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.domain.Usuario;
import java.util.Set;
import java.util.stream.Collectors;

/*
DTO de salida. Separa el contrato HTTP del dominio para que los atributos
internos de Usuario no se expongan automaticamente como JSON.
*/
public record UsuarioResponse(String username, String email, boolean activo, Set<String> roles) {
    public static UsuarioResponse desde(Usuario usuario) {
        Set<String> nombresRoles = usuario.getRoles().stream()
                .map(rol -> rol.getNombre())
                .collect(Collectors.toSet());
        return new UsuarioResponse(usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo(), nombresRoles);
    }
}
