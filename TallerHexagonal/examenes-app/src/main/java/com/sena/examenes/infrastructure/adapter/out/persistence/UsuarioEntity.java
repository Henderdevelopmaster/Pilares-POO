package com.sena.examenes.infrastructure.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

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
    private String passwordHash;

    @Column(nullable = false)
    private boolean activo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolEntity> roles = new HashSet<>();

    public UsuarioEntity() {
        // Constructor vacio exigido por Hibernate.
    }

    public UsuarioEntity(Long id, String username, String email, String passwordHash, boolean activo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.activo = activo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public boolean isActivo() { return activo; }
    public Set<RolEntity> getRoles() { return roles; }
    public void setRoles(Set<RolEntity> roles) { this.roles = roles; }
}
