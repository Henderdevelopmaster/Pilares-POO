package com.sena.examenes.infrastructure.adapter.in.rest;

/* DTO de entrada: record representa de forma concisa datos inmutables del JSON. */
public record UsuarioRequest(String username, String email) {
}
