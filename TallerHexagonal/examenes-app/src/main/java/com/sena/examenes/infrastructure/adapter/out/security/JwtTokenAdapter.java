package com.sena.examenes.infrastructure.adapter.out.security;

import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.domain.Usuario;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/*
-------------------------------------------------------
Clase: JwtTokenAdapter
Un JWT tiene header, payload legible y firma. No es texto encriptado: cualquiera
puede leer el payload, pero la firma detecta modificaciones. La clave se crea
en memoria al arrancar, por eso los tokens cambian al reiniciar.
-------------------------------------------------------
*/
@Component
public class JwtTokenAdapter implements TokenPort {
    private final SecretKey clave = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private static final long DURACION_MS = 60 * 60 * 1000L;

    @Override
    public String generar(Usuario usuario) {
        String roles = usuario.getRoles().stream().map(r -> r.getNombre()).collect(Collectors.joining(","));
        Date ahora = new Date();
        return Jwts.builder().subject(usuario.getUsername()).claim("roles", roles)
                .issuedAt(ahora).expiration(new Date(ahora.getTime() + DURACION_MS))
                .signWith(clave).compact();
    }

    @Override
    public Optional<String> validarYObtenerUsername(String token) {
        try {
            return Optional.ofNullable(Jwts.parser().verifyWith(clave).build()
                    .parseSignedClaims(token).getPayload().getSubject());
        } catch (JwtException | IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
