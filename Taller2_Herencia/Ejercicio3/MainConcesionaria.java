/*
-------------------------------------------------------
Clase: MainConcesionaria

Punto de entrada del programa. Crea un Carro y una Moto, y
llama a describir() en cada uno para comprobar que el
método combina correctamente la información heredada
(marca, modelo, precio) con la información propia de cada
tipo (puertas o cilindraje).
-------------------------------------------------------
*/
public class MainConcesionaria {

    public static void main(String[] args) {

        // new Carro(...) y new Moto(...) reservan memoria y
        // ejecutan la cadena de constructores: primero
        // Vehiculo (vía super), luego el propio de cada hija.
        Carro c = new Carro("Chevrolet", "Spark", 45000000, 4);
        Moto m = new Moto("Yamaha", "FZ", 12000000, 250);

        // Camioneta: objeto agregado como parte del RETO DE
        // ANDAMIAJE del Ejercicio 3. Sigue exactamente el
        // mismo patrón que Carro y Moto: extiende de Vehiculo
        // y reutiliza describir() con super.describir().
        Camioneta ca = new Camioneta("Toyota", "Hilux", 130000000, 1200);

        // c.describir() ejecuta la versión sobrescrita en
        // Carro, que primero llama a super.describir() (la
        // del padre) y luego imprime su propia línea extra.
        c.describir();

        System.out.println("---");

        m.describir();

        System.out.println("---");

        ca.describir();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Chevrolet Spark - $4.5E7
         * Tipo: Carro - 4 puertas
         * ---
         * Yamaha FZ - $1.2E7
         * Tipo: Moto - 250 cc
         * ---
         * Toyota Hilux - $1.3E8
         * Tipo: Camioneta - 1200 kg de carga
         *
         * Nota: Java puede mostrar los precios en notación
         * científica porque son valores double grandes; esto
         * es un detalle normal del tipo de dato, no un error.
         */
    }
}
