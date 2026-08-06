/*
-------------------------------------------------------
Clase: MainFiguras

Punto de entrada del programa educativo de figuras.
Crea un Circulo y un Rectangulo, y muestra en consola su
color (heredado de Figura mediante getColor()) junto con
su área (calculada con la fórmula propia de cada figura).
-------------------------------------------------------
*/
public class MainFiguras {

    public static void main(String[] args) {

        // Se crean dos objetos: un Circulo de color "Rojo"
        // con radio 5, y un Rectangulo de color "Azul" con
        // ancho 4 y alto 6. En memoria, cada uno guarda tanto
        // los datos heredados de Figura (color) como sus
        // propios atributos (radio, o ancho/alto).
        Circulo c = new Circulo("Rojo", 5);
        Rectangulo r = new Rectangulo("Azul", 4, 6);

        // Triangulo: objeto agregado como parte del RETO DE
        // ANDAMIAJE del Ejercicio 4. Extiende de Figura igual
        // que Circulo y Rectangulo, solo cambia su fórmula de
        // área.
        Triangulo t = new Triangulo("Verde", 8, 5);

        // c.getColor() está heredado de Figura y no fue
        // sobrescrito, así que se ejecuta tal cual está
        // definido en el padre. c.calcularArea() SÍ fue
        // sobrescrito, así que se ejecuta la fórmula propia
        // del círculo.
        System.out.println("Circulo " + c.getColor() +
                " - Area: " + c.calcularArea());

        System.out.println("Rectangulo " + r.getColor() +
                " - Area: " + r.calcularArea());

        System.out.println("Triangulo " + t.getColor() +
                " - Area: " + t.calcularArea());

        System.out.println("---");

        // describir() es el método agregado como RETO EXTRA en
        // la clase padre Figura. Funciona igual para las tres
        // figuras sin sobrescribirse en ninguna, porque llama
        // internamente a calcularArea(), y Java resuelve en
        // tiempo de ejecución cuál versión usar según el tipo
        // real de cada objeto.
        c.describir();
        r.describir();
        t.describir();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Circulo Rojo - Area: 78.53981633974483
         * Rectangulo Azul - Area: 24.0
         * Triangulo Verde - Area: 20.0
         * ---
         * Figura de color Rojo con area: 78.53981633974483
         * Figura de color Azul con area: 24.0
         * Figura de color Verde con area: 20.0
         */
    }
}
