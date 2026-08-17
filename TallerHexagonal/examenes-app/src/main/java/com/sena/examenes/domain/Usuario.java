package com.sena.examenes.domain;

import java.util.HashSet;
import java.util.Set;

/*
-------------------------------------------------------
Clase: Usuario
Representa el agregado de usuario sin depender de JWT, Spring Security, JPA
ni ninguna tecnologia externa.
-------------------------------------------------------
*/
public class Usuario {
    private String username;
    private String email;
    private String passwordHash;
    private boolean activo;
    private final Set<Rol> roles;

    public Usuario(String username, String email, String passwordHash) {
        if (username == null || username.isBlank()) throw new IllegalArgumentException("El username no puede estar vacio.");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("El email no puede estar vacio.");
        if (passwordHash == null || passwordHash.isBlank()) throw new IllegalArgumentException("El passwordHash no puede estar vacio.");
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.activo = true;
        this.roles = new HashSet<>();
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    /*
    Este getter no rompe el encapsulamiento del Taller 1: expone un hash de un
    solo sentido, nunca la contrasena en texto plano, para que la autenticacion
    pueda verificarla mediante un puerto desacoplado de Spring Security.
    */
    public String getPasswordHash() { return passwordHash; }
    public boolean isActivo() { return activo; }
    public void desactivar() { this.activo = false; }

    public void asignarRol(Rol rol) {
        if (rol == null) throw new IllegalArgumentException("El rol no puede ser nulo.");
        roles.add(rol);
    }

    public boolean tieneRol(String nombreRol) {
        return roles.stream().anyMatch(r -> r.getNombre().equalsIgnoreCase(nombreRol));
    }

    public Set<Rol> getRoles() { return Set.copyOf(roles); }
}
