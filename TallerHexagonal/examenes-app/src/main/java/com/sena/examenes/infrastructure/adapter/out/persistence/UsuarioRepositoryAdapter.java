package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Clase: UsuarioRepositoryAdapter

Adaptador de salida real. @Repository registra la clase como componente de
acceso a datos. Implementa el puerto OUT y conecta el modelo de dominio con
Spring Data JPA mediante inyeccion de dependencias por constructor.
-------------------------------------------------------
*/
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {
    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository,
                                     UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        // Conserva el id existente para que save haga UPDATE y mantiene roles.
        UsuarioEntity entity = mapper.aEntity(usuario);
        jpaRepository.findByUsernameIgnoreCase(usuario.getUsername())
                .ifPresent(actual -> entity.setId(actual.getId()));
        UsuarioEntity guardado = jpaRepository.save(entity);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return jpaRepository.findByUsernameIgnoreCase(username).map(mapper::aDominio);
    }

    @Override
    public List<Usuario> listarActivos() {
        return jpaRepository.findByActivoTrue().stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public boolean existePorUsername(String username) {
        return jpaRepository.existsByUsernameIgnoreCase(username);
    }
}
