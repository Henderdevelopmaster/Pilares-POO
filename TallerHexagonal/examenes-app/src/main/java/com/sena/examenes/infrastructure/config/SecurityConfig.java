package com.sena.examenes.infrastructure.config;

import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.infrastructure.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
-------------------------------------------------------
Clase: SecurityConfig
@Configuration y @Bean registran objetos administrados por Spring; @EnableWebSecurity
activa seguridad. Autenticacion identifica; autorizacion decide permisos. CSRF se
deshabilita porque una API stateless usa Bearer y no cookies; STATELESS impide
sesiones. Spring exige ROLE_ antes de los nombres al comprobar hasRole.
-------------------------------------------------------
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(TokenPort tokens, UsuarioRepositoryPort usuarios) {
        return new JwtAuthenticationFilter(tokens, usuarios);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwt) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/usuarios").permitAll()
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/roles").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(jwt, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
