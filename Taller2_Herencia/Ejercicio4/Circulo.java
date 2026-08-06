/*
-------------------------------------------------------
Clase: Circulo

Representa un círculo. Un Circulo ES UNA Figura (extends
Figura), y agrega su propio atributo: el radio, necesario
para calcular su área con la fórmula π × r².
-------------------------------------------------------
*/
public class Circulo extends Figura {

    private double radio; // Distancia desde el centro hasta el borde del círculo

    /*
     * Constructor de Circulo.
     * super(color) inicializa la parte heredada de Figura.
     * Luego se guarda el radio, propio de esta clase.
     */
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    /*
     * @Override
     * Sobrescribimos calcularArea() porque la fórmula del
     * círculo es específica: π multiplicado por el radio al
     * cuadrado.
     *
     * Math.PI: es una CONSTANTE ya definida en la clase Math
     * de Java, que representa el número π (aproximadamente
     * 3.14159...). Se usa en vez de escribir el número a mano
     * para tener mayor precisión y claridad en el código.
     *
     * Qué devuelve: un double con el área calculada.
     */
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
