package com.sena.examenes.application.port.out;

/* Puerto de salida: el caso de uso conoce una capacidad, no Spring Security. */
public interface PasswordEncoderPort {
    String codificar(String password);
    boolean verificar(String password, String hash);
}
