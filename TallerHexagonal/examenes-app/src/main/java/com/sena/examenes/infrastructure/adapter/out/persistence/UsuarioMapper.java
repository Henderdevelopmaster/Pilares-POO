package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Component;

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
    public UsuarioEntity aEntity(Usuario usuario) {
        return new UsuarioEntity(null, usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo());
    }

    public Usuario aDominio(UsuarioEntity entity) {
        Usuario usuario = new Usuario(entity.getUsername(), entity.getEmail());
        if (!entity.isActivo()) {
            usuario.desactivar();
        }
        return usuario;
    }
}
