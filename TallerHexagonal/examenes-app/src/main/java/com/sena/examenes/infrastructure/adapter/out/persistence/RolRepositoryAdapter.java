package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.domain.Rol;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/* Adaptador OUT que conecta RolRepositoryPort con Spring Data JPA. */
@Repository
public class RolRepositoryAdapter implements RolRepositoryPort {
    private final RolJpaRepository jpaRepository;
    private final RolMapper mapper;

    public RolRepositoryAdapter(RolJpaRepository jpaRepository, RolMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Rol guardar(Rol rol) {
        RolEntity guardado = jpaRepository.save(mapper.aEntity(rol));
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Rol> buscarPorNombre(String nombre) {
        return jpaRepository.findByNombreIgnoreCase(nombre).map(mapper::aDominio);
    }

    @Override
    public List<Rol> listarTodos() {
        return jpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }
}
