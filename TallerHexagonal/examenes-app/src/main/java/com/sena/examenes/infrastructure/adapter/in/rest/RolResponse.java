package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.domain.Rol;

/* DTO de salida: separa el contrato HTTP del objeto de dominio. */
public record RolResponse(String nombre, String descripcion) {
    public static RolResponse desde(Rol rol) {
        return new RolResponse(rol.getNombre(), rol.getDescripcion());
    }
}
