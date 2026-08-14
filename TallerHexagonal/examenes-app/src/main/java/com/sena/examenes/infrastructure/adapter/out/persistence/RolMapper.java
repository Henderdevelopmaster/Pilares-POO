package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.domain.Permiso;
import com.sena.examenes.domain.Rol;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

/*
-------------------------------------------------------
Clase: RolMapper

Mapper del reto Permiso. Traduce Rol y Permiso entre dominio y JPA. Consulta
siempre el PermisoEntity existente antes de formar rol_permiso; crear una
entidad nueva con id null haria que Hibernate intentara insertar duplicados.
-------------------------------------------------------
*/
@Component
public class RolMapper {
    private final PermisoJpaRepository permisoJpaRepository;

    public RolMapper(PermisoJpaRepository permisoJpaRepository) {
        this.permisoJpaRepository = permisoJpaRepository;
    }

    public RolEntity aEntity(Rol rol) {
        RolEntity entity = new RolEntity(null, rol.getNombre(), rol.getDescripcion());
        entity.setPermisos(rol.getPermisos().stream()
                .map(this::buscarPermisoEntityExistente)
                .collect(Collectors.toSet()));
        return entity;
    }

    private PermisoEntity buscarPermisoEntityExistente(Permiso permiso) {
        return permisoJpaRepository.findByNombreIgnoreCase(permiso.getNombre())
                .orElseThrow(() -> new IllegalStateException(
                        "El permiso '" + permiso.getNombre() + "' no existe en BD."));
    }

    public Rol aDominio(RolEntity entity) {
        Rol rol = new Rol(entity.getNombre(), entity.getDescripcion());
        entity.getPermisos().forEach(permiso -> rol.asignarPermiso(
                new Permiso(permiso.getNombre(), permiso.getDescripcion())));
        return rol;
    }
}
