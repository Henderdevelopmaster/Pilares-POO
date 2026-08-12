package com.sena.examenes.infrastructure.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
-------------------------------------------------------
Clase: UsuarioEntity

Modelo exclusivo de infraestructura. @Entity y @Table indican a JPA que esta
clase representa la tabla usuarios; el dominio Usuario permanece libre de
anotaciones. El constructor vacio es requerido por Hibernate para reconstruir
filas, aunque la aplicacion no lo use directamente.
-------------------------------------------------------
*/
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean activo;

    public UsuarioEntity() {
        // Constructor vacio exigido por Hibernate.
    }

    public UsuarioEntity(Long id, String username, String email, boolean activo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }
}
