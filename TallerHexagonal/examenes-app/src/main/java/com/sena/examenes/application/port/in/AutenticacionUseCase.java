package com.sena.examenes.application.port.in;

/* Puerto de entrada para autenticarse; devuelve el JWT al adaptador REST. */
public interface AutenticacionUseCase {
    String login(String username, String password);
}
