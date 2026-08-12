package com.sena.examenes;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.service.UsuarioService;

/*
-------------------------------------------------------
Clase: MainUsuarios

Prueba la Sesion 1 sin iniciar Spring. La variable se declara como el puerto
de entrada, no como una lista ni como un detalle de persistencia: ese es el
limite visible para quien usa el sistema.
-------------------------------------------------------
*/
public class MainUsuarios {
    public static void main(String[] args) {
        UsuarioUseCase usuarioUseCase = new UsuarioService();
        usuarioUseCase.registrar("cbarrientos", "cbarrientos@sena.edu.co");
        usuarioUseCase.registrar("lgomez", "lgomez@sena.edu.co");

        try {
            usuarioUseCase.registrar("cbarrientos", "otro@correo.com");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        usuarioUseCase.buscarPorUsername("lgomez")
                .ifPresent(u -> System.out.println("Encontrado: " + u.getEmail()));

        // El reto desactiva un usuario y demuestra que ya no aparece entre activos.
        usuarioUseCase.desactivarUsuario("lgomez");
        int totalActivos = usuarioUseCase.listarActivos().size();
        System.out.println("Usuarios activos despues de desactivar: " + totalActivos);

        try {
            usuarioUseCase.desactivarUsuario("noexiste");
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}
