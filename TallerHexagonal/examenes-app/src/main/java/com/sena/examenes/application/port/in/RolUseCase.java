package com.sena.examenes.application.port.in;

import com.sena.examenes.domain.Rol;
import java.util.List;

/*
-------------------------------------------------------
Interfaz: RolUseCase

Puerto de entrada que define las operaciones de negocio disponibles para
roles. Un controller REST depende de este contrato, no de RolService.
-------------------------------------------------------
*/
public interface RolUseCase {
    Rol crear(String nombre, String descripcion);
    List<Rol> listarTodos();
}
