/*
-------------------------------------------------------
Clase: Figura

Representa el concepto general de una figura geométrica.
Todas las figuras comparten un color, pero cada una calcula
su área de forma distinta. Por eso, calcularArea() existe
aquí solo como un valor "por defecto" (0), esperando que
cada hija lo sobrescriba con su propia fórmula matemática.
-------------------------------------------------------
*/
public class Figura {

    protected String color; // Color de la figura (ej: "Rojo")

    /*
     * Constructor de Figura. Inicializa el único atributo
     * común a todas las figuras: el color.
     */
    public Figura(String color) {
        this.color = color;
    }

    /*
     * calcularArea()
     * Para qué sirve: da un valor de área "genérico" (0),
     * porque la clase Figura por sí sola no representa una
     * forma real con fórmula matemática propia.
     * Por qué existe en el padre: para que TODAS las hijas
     * garanticen tener un método calcularArea(), y para que
     * el programa pueda tratarlas de forma uniforme (por
     * ejemplo, en un futuro, dentro de una lista de Figuras).
     * Qué devuelve: 0 por defecto; cada hija sobrescribe este
     * valor con su propio cálculo.
     */
    public double calcularArea() {
        return 0; // Sera sobrescrito por las hijas
    }

    /*
     * getColor()
     * Método "getter": su única función es devolver el valor
     * del atributo color. Se usa cuando, desde fuera de la
     * clase, se necesita leer el color sin acceder
     * directamente al atributo.
     * Qué devuelve: un String con el color de la figura.
     */
    public String getColor() {
        return color;
    }

    /*
     * describir()
     * Método agregado como parte del RETO EXTRA del taller:
     * "agrega un método describir() en la clase padre que
     * muestre el color y el área, y aprovéchalo desde el
     * main."
     *
     * Para qué sirve: imprime en una sola línea el color de
     * la figura y su área calculada.
     * Por qué funciona igual para Circulo, Rectangulo y
     * Triangulo sin necesidad de sobrescribirlo: este método
     * llama internamente a calcularArea(), y gracias al
     * polimorfismo, Java ejecuta automáticamente la versión
     * sobrescrita correspondiente al tipo real del objeto
     * (Circulo, Rectangulo o Triangulo), tal como ocurrió con
     * mostrarInfo() en la clase Empleado del Ejercicio 2.
     * Qué devuelve: nada (void), solo imprime un mensaje.
     */
    public void describir() {
        System.out.println("Figura de color " + color + " con area: " + calcularArea());
    }
}
