package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.AutenticacionUseCase;
import com.sena.examenes.application.port.out.PasswordEncoderPort;
import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Service;

/*
-------------------------------------------------------
Clase: AutenticacionService
Login autentica identidad y luego TokenPort emite el token. Un mismo mensaje
para usuario inexistente y clave incorrecta evita enumerar usuarios validos.
-------------------------------------------------------
*/
@Service
public class AutenticacionService implements AutenticacionUseCase {
    private final UsuarioRepositoryPort usuarios;
    private final PasswordEncoderPort passwords;
    private final TokenPort tokens;

    public AutenticacionService(UsuarioRepositoryPort usuarios, PasswordEncoderPort passwords, TokenPort tokens) {
        this.usuarios = usuarios;
        this.passwords = passwords;
        this.tokens = tokens;
    }

    @Override
    public String login(String username, String password) {
        Usuario usuario = usuarios.buscarPorUsername(username).orElse(null);
        if (usuario == null || !passwords.verificar(password, usuario.getPasswordHash())) {
            throw new IllegalStateException("Username o password incorrectos.");
        }
        return tokens.generar(usuario);
    }
}
