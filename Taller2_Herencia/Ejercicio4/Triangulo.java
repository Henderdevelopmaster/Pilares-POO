/*
-------------------------------------------------------
Clase: Triangulo

Esta clase resuelve el RETO DE ANDAMIAJE del Ejercicio 4:
"Crea una tercera clase hija Triangulo que reciba base y
altura. El área de un triángulo es (base × altura) / 2."

Un Triangulo ES UNA Figura (extends Figura), con dos
atributos propios: base y altura, necesarios para calcular
su área con la fórmula geométrica correspondiente.
-------------------------------------------------------
*/
public class Triangulo extends Figura {

    private double base;  // Longitud de la base del triángulo
    private double altura; // Altura del triángulo, medida desde la base hasta el vértice opuesto

    /*
     * Constructor de Triangulo.
     * super(color) construye la parte heredada de Figura, y
     * luego se inicializan base y altura, propios de esta
     * clase.
     */
    public Triangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    /*
     * @Override
     * El área de un triángulo se calcula como (base × altura)
     * dividido entre 2. Esta fórmula es distinta a la del
     * círculo y a la del rectángulo, lo que confirma por qué
     * calcularArea() debe sobrescribirse en cada figura hija:
     * cada una tiene su propia lógica matemática.
     */
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}
