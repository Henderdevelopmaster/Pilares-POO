package com.sena.examenes.infrastructure.adapter.in.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;

/*
-------------------------------------------------------
Clase: ManejadorGlobalDeErrores
@ControllerAdvice cumple para los controllers el mismo rol que un mapper para
las entidades: una responsabilidad centralizada y reutilizada por todos.
-------------------------------------------------------
*/
@ControllerAdvice
public class ManejadorGlobalDeErrores {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarEstado(IllegalStateException e, HttpServletRequest request) {
        HttpStatus status = request.getRequestURI().equals("/api/auth/login")
                ? HttpStatus.UNAUTHORIZED : HttpStatus.CONFLICT;
        return ResponseEntity.status(status).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarArgumento(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> manejarNoEncontrado(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
