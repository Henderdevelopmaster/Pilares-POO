package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.domain.Usuario;
import com.sena.examenes.domain.Rol;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

/*
-------------------------------------------------------
Clase: UsuarioMapper

Adaptador de traduccion entre el dominio y la entidad JPA. @Component permite
que Spring cree este objeto e inyecte la misma instancia donde se necesite.
Asi UsuarioEntity no se filtra hacia el servicio ni hacia el controller.
-------------------------------------------------------
*/
@Component
public class UsuarioMapper {
    private final RolJpaRepository rolJpaRepository;

    public UsuarioMapper(RolJpaRepository rolJpaRepository) {
        this.rolJpaRepository = rolJpaRepository;
    }

    public UsuarioEntity aEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity(null, usuario.getUsername(),
                usuario.getEmail(), usuario.isActivo());
        entity.setRoles(usuario.getRoles().stream()
                .map(this::buscarRolEntityExistente)
                .collect(Collectors.toSet()));
        return entity;
    }

    private RolEntity buscarRolEntityExistente(Rol rol) {
        return rolJpaRepository.findByNombreIgnoreCase(rol.getNombre())
                .orElseThrow(() -> new IllegalStateException(
                        "El rol '" + rol.getNombre() + "' no existe en BD."));
    }

    public Usuario aDominio(UsuarioEntity entity) {
        Usuario usuario = new Usuario(entity.getUsername(), entity.getEmail());
        if (!entity.isActivo()) {
            usuario.desactivar();
        }
        entity.getRoles().forEach(rolEntity -> usuario.asignarRol(
                new Rol(rolEntity.getNombre(), rolEntity.getDescripcion())));
        return usuario;
    }
}
