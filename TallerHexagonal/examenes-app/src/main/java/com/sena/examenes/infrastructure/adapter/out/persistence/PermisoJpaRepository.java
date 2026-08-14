package com.sena.examenes.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/* Repositorio del reto: Spring implementa la consulta automaticamente. */
public interface PermisoJpaRepository extends JpaRepository<PermisoEntity, Long> {
    Optional<PermisoEntity> findByNombreIgnoreCase(String nombre);
}
