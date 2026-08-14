package com.sena.examenes.application.port.out;

import com.sena.examenes.domain.Rol;
import java.util.List;
import java.util.Optional;

/* Puerto de salida: expresa lo que la aplicacion necesita para persistir roles. */
public interface RolRepositoryPort {
    Rol guardar(Rol rol);
    Optional<Rol> buscarPorNombre(String nombre);
    List<Rol> listarTodos();
}
