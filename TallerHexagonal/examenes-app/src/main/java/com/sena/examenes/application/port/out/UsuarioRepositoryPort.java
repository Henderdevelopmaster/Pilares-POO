package com.sena.examenes.application.port.out;

import com.sena.examenes.domain.Usuario;
import java.util.List;
import java.util.Optional;

/*
-------------------------------------------------------
Interfaz: UsuarioRepositoryPort

Es el puerto de salida. Expresa lo que la aplicacion necesita del exterior
para guardar y consultar usuarios, sin mencionar JPA, MySQL ni Spring Data.
El adaptador de persistencia implementa este contrato.
-------------------------------------------------------
*/
public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorUsername(String username);
    List<Usuario> listarActivos();
    boolean existePorUsername(String username);
}
