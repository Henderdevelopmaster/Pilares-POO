package com.sena.examenes.infrastructure.adapter.in.rest;

/* DTO inmutable que representa el JSON recibido al crear un rol. */
public record RolRequest(String nombre, String descripcion) {
}
