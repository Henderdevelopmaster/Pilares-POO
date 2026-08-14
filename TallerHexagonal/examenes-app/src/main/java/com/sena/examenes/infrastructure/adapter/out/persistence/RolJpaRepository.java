package com.sena.examenes.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/* Spring Data genera la consulta por nombre leyendo el nombre del metodo. */
public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
    Optional<RolEntity> findByNombreIgnoreCase(String nombre);
}
