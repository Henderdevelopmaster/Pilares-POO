package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.AutenticacionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
-------------------------------------------------------
Clase: AuthController
Adaptador REST del login. Solo traduce HTTP al puerto de entrada; el manejo
global convierte el error generico de login en 401.
-------------------------------------------------------
*/
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AutenticacionUseCase autenticacion;
    public AuthController(AutenticacionUseCase autenticacion) { this.autenticacion = autenticacion; }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(new TokenResponse(autenticacion.login(request.username(), request.password())));
    }
}
