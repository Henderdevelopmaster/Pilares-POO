/*
-------------------------------------------------------
Clase: Rectangulo

Representa un rectángulo. Un Rectangulo ES UNA Figura
(extends Figura), y agrega dos atributos propios: ancho y
alto, necesarios para calcular su área.
-------------------------------------------------------
*/
public class Rectangulo extends Figura {

    private double ancho; // Medida horizontal del rectángulo
    private double alto;  // Medida vertical del rectángulo

    /*
     * Constructor de Rectangulo.
     * super(color) construye la parte heredada de Figura, y
     * luego se inicializan ancho y alto, propios de esta
     * clase.
     */
    public Rectangulo(String color, double ancho, double alto) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    /*
     * @Override
     * El área de un rectángulo se calcula multiplicando su
     * ancho por su alto. Esta fórmula es distinta a la del
     * círculo, lo cual demuestra por qué calcularArea() debe
     * sobrescribirse en cada hija: cada figura tiene su
     * propia lógica matemática.
     */
    @Override
    public double calcularArea() {
        return ancho * alto;
    }
}
