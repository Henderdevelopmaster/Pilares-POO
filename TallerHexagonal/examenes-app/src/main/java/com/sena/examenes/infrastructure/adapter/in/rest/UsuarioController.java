package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/*
-------------------------------------------------------
Clase: UsuarioController

Adaptador de entrada REST. @RestController convierte esta clase en un punto de
entrada HTTP y @RequestMapping fija el prefijo de sus rutas. Solo conoce el
puerto UsuarioUseCase; no conoce ArrayList, JPA ni MySQL.
-------------------------------------------------------
*/
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioUseCase usuarioUseCase;

    // Spring inyecta por constructor la implementacion del puerto de entrada.
    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioUseCase.registrar(request.username(), request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.desde(usuario));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable String username) {
        return usuarioUseCase.buscarPorUsername(username)
                .map(UsuarioResponse::desde)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UsuarioResponse> listarActivos() {
        return usuarioUseCase.listarActivos().stream()
                .map(UsuarioResponse::desde)
                .toList();
    }

    /* Reto: PATCH cambia solo el estado activo y reutiliza el caso de uso. */
    @PatchMapping("/{username}/desactivar")
    public ResponseEntity<UsuarioResponse> desactivar(@PathVariable String username) {
        usuarioUseCase.desactivarUsuario(username);
        return usuarioUseCase.buscarPorUsername(username)
                .map(UsuarioResponse::desde)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{username}/roles/{nombreRol}")
    public ResponseEntity<UsuarioResponse> asignarRol(
            @PathVariable String username,
            @PathVariable String nombreRol) {
        Usuario usuario = usuarioUseCase.asignarRol(username, nombreRol);
        return ResponseEntity.ok(UsuarioResponse.desde(usuario));
    }

}
