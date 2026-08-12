package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.domain.Usuario;

/*
DTO de salida. Separa el contrato HTTP del dominio para que los atributos
internos de Usuario no se expongan automaticamente como JSON.
*/
public record UsuarioResponse(String username, String email, boolean activo) {
    public static UsuarioResponse desde(Usuario usuario) {
        return new UsuarioResponse(usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo());
    }
}
