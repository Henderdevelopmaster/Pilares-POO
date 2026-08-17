package com.sena.examenes.infrastructure.security;

import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.stream.Collectors;

/*
-------------------------------------------------------
Clase: JwtAuthenticationFilter
Un filtro OncePerRequestFilter se ejecuta una vez por peticion, antes de llegar
a cualquier controller. Por eso la autenticacion JWT no pertenece al controller.
Si no hay token o es invalido, deja que SecurityConfig decida el acceso.
-------------------------------------------------------
*/
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final TokenPort tokens;
    private final UsuarioRepositoryPort usuarios;
    public JwtAuthenticationFilter(TokenPort tokens, UsuarioRepositoryPort usuarios) {
        this.tokens = tokens; this.usuarios = usuarios;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            tokens.validarYObtenerUsername(header.substring(7)).flatMap(usuarios::buscarPorUsername)
                    .ifPresent(this::autenticar);
        }
        chain.doFilter(request, response);
    }

    private void autenticar(Usuario usuario) {
        var authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre().toUpperCase()))
                .collect(Collectors.toSet());
        var authentication = new UsernamePasswordAuthenticationToken(usuario.getUsername(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
