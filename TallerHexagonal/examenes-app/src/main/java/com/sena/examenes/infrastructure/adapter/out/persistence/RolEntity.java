package com.sena.examenes.infrastructure.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/*
-------------------------------------------------------
Clase: RolEntity

Representa la tabla roles y, en el reto, la relacion con permisos. @ManyToMany
indica que ambos lados pueden repetirse en la relacion; @JoinTable define la
tabla puente rol_permiso. La relacion es unidireccional para evitar ciclos al
recorrer roles y permisos.
-------------------------------------------------------
*/
@Entity
@Table(name = "roles")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_permiso",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "permiso_id"))
    private Set<PermisoEntity> permisos = new HashSet<>();

    public RolEntity() { }

    public RolEntity(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Set<PermisoEntity> getPermisos() { return permisos; }
    public void setPermisos(Set<PermisoEntity> permisos) { this.permisos = permisos; }
}
