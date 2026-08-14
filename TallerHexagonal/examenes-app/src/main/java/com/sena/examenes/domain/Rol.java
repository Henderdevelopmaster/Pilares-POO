package com.sena.examenes.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
-------------------------------------------------------
Clase: Rol

Representa un rol de negocio, como ADMIN o APRENDIZ. Es una clase de dominio
pura: no conoce Spring ni JPA. Su igualdad se define por nombre, porque dos
roles con el mismo nombre representan el mismo concepto aunque su descripcion
o instancia en memoria sean distintas.
-------------------------------------------------------
*/
public class Rol {
    private final String nombre;
    private final String descripcion;
    private final Set<Permiso> permisos;

    public Rol(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacio.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.permisos = new HashSet<>();
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    /*
    El HashSet evita permisos repetidos. La validacion de nulo protege el
    dominio de una relacion invalida antes de llegar a infraestructura.
    */
    public void asignarPermiso(Permiso permiso) {
        if (permiso == null) {
            throw new IllegalArgumentException("El permiso no puede ser nulo.");
        }
        permisos.add(permiso);
    }

    public Set<Permiso> getPermisos() {
        return Set.copyOf(permisos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol)) return false;
        Rol otro = (Rol) o;
        return nombre.equalsIgnoreCase(otro.nombre);
    }

    @Override
    public int hashCode() {
        // equals y hashCode usan la misma regla: nombre ignorando mayusculas.
        return Objects.hash(nombre.toLowerCase());
    }
}
