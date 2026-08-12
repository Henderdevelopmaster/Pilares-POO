package com.sena.examenes.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Interfaz: UsuarioJpaRepository

Spring Data implementa esta interfaz automaticamente. Al extender
JpaRepository recibe save y consultas basicas; los nombres de los metodos
findBy..., existsBy... se convierten en consultas SQL por convencion.
-------------------------------------------------------
*/
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsernameIgnoreCase(String username);
    List<UsuarioEntity> findByActivoTrue();
    boolean existsByUsernameIgnoreCase(String username);
}
