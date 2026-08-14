package com.sena.examenes.domain;

import java.util.Objects;

/*
-------------------------------------------------------
Clase: Permiso

Reto de andamiaje: representa una capacidad concreta que puede pertenecer a
varios roles. Mantiene el dominio independiente de la tabla rol_permiso.
equals() y hashCode() comparan por nombre para que un Set no duplique permisos.
-------------------------------------------------------
*/
public class Permiso {
    private final String nombre;
    private final String descripcion;

    public Permiso(String nombre, String descripcion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del permiso no puede estar vacio.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permiso)) return false;
        Permiso otro = (Permiso) o;
        return nombre.equalsIgnoreCase(otro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }
}
