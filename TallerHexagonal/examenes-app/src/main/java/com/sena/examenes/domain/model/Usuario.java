package com.sena.examenes.domain;

import java.util.HashSet;
import java.util.Set;

/*
-------------------------------------------------------
Clase: Usuario

Representa la regla de negocio central del sistema de examenes. Es un POJO
del dominio: no importa Spring, JPA ni ninguna clase de infrastructure.
Por eso puede reutilizarse y probarse aunque cambie la tecnologia externa.
-------------------------------------------------------
*/
public class Usuario {
    // private protege el estado; las operaciones publicas controlan sus cambios.
    private String username;
    private String email;
    private boolean activo;
    private final Set<Rol> roles;

    /*
    Constructor del dominio. Valida los datos propios del usuario y lo crea
    activo. Si un dato es invalido, IllegalArgumentException informa el error.
    */
    public Usuario(String username, String email) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El username no puede estar vacio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacio.");
        }
        this.username = username;
        this.email = email;
        this.activo = true;
        this.roles = new HashSet<>();
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }

    // El dominio expone una accion, no un setter, para proteger la regla de estado.
    public void desactivar() {
        this.activo = false;
    }

    /*
    Set no permite duplicados. Como Rol sobrescribe equals/hashCode por nombre,
    asignar dos veces ADMIN deja una sola entrada sin un if adicional.
    */
    public void asignarRol(Rol rol) {
        if (rol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo.");
        }
        roles.add(rol);
    }

    public boolean tieneRol(String nombreRol) {
        return roles.stream()
                .anyMatch(r -> r.getNombre().equalsIgnoreCase(nombreRol));
    }

    /* Set.copyOf evita que quien recibe el resultado modifique el conjunto interno. */
    public Set<Rol> getRoles() {
        return Set.copyOf(roles);
    }
}
