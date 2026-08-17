package com.sena.examenes.application.port.in;

import com.sena.examenes.domain.Usuario;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Interfaz: UsuarioUseCase

Es el puerto de entrada de la arquitectura hexagonal. Declara que puede pedir
el mundo exterior al sistema, pero no dice si detras hay consola, REST o una
prueba. El servicio implementa este contrato y los adaptadores lo consumen.
-------------------------------------------------------
*/
public interface UsuarioUseCase {
    Usuario registrar(String username, String email, String password);
    Optional<Usuario> buscarPorUsername(String username);
    List<Usuario> listarActivos();
    void desactivarUsuario(String username);
    Usuario asignarRol(String username, String nombreRol);
}
