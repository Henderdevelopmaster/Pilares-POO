package com.sena.examenes.domain;

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
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }

    // El dominio expone una accion, no un setter, para proteger la regla de estado.
    public void desactivar() {
        this.activo = false;
    }
}
