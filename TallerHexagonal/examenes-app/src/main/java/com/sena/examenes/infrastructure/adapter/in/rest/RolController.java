package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.RolUseCase;
import com.sena.examenes.domain.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/*
-------------------------------------------------------
Clase: RolController

Adaptador de entrada REST. @RestController recibe HTTP y delega en el puerto
RolUseCase. La validacion de duplicados sigue viviendo en RolService, no en
este adaptador, para mantener separadas entrada y logica de negocio.
-------------------------------------------------------
*/
@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolUseCase rolUseCase;

    public RolController(RolUseCase rolUseCase) {
        this.rolUseCase = rolUseCase;
    }

    @PostMapping
    public ResponseEntity<RolResponse> crear(@RequestBody RolRequest request) {
        Rol rol = rolUseCase.crear(request.nombre(), request.descripcion());
        return ResponseEntity.status(HttpStatus.CREATED).body(RolResponse.desde(rol));
    }

    @GetMapping
    public List<RolResponse> listarTodos() {
        return rolUseCase.listarTodos().stream()
                .map(RolResponse::desde)
                .toList();
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarDuplicado(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
