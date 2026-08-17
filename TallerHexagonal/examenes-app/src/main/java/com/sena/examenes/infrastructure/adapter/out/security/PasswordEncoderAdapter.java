package com.sena.examenes.infrastructure.adapter.out.security;

import com.sena.examenes.application.port.out.PasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/*
-------------------------------------------------------
Clase: PasswordEncoderAdapter
BCrypt almacena un hash no reversible. El adaptador encierra Spring Security
para que la aplicacion solo dependa de PasswordEncoderPort.
-------------------------------------------------------
*/
@Component
public class PasswordEncoderAdapter implements PasswordEncoderPort {
    private final PasswordEncoder encoder;

    public PasswordEncoderAdapter(PasswordEncoder encoder) { this.encoder = encoder; }
    @Override public String codificar(String password) { return encoder.encode(password); }
    @Override public boolean verificar(String password, String hash) { return encoder.matches(password, hash); }
}
