package com.sena.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
-------------------------------------------------------
Clase: ExamenesAppApplication

Punto de entrada de Spring Boot. La anotacion @SpringBootApplication combina
configuracion, descubrimiento de componentes y autoconfiguracion de Spring.
En la Sesion 1 la prueba principal es MainUsuarios; esta clase queda lista para
conectar los adaptadores reales en la Sesion 2.
-------------------------------------------------------
*/
@SpringBootApplication
public class ExamenesAppApplication {

    public static void main(String[] args) {
        // SpringApplication crea el contexto donde Spring administra los beans.
        SpringApplication.run(ExamenesAppApplication.class, args);
    }
}
