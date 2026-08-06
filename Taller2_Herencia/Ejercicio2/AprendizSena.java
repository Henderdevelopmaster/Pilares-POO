/*
-------------------------------------------------------
Clase: AprendizSena

Esta clase resuelve el RETO DE ANDAMIAJE del Ejercicio 2:
"Crea una tercera clase hija AprendizSena que extienda de
Empleado. Un aprendiz gana el 50% del salario base como
apoyo de sostenimiento (según la normativa vigente).
Sobrescribe calcularSalario() para reflejar esto."

Un AprendizSena ES UN Empleado (extends Empleado), pero su
forma de pago es distinta: no gana comisión ni bonificación
fija como Vendedor o Gerente, sino la mitad de su salario
base, en forma de apoyo de sostenimiento.
-------------------------------------------------------
*/
public class AprendizSena extends Empleado {

    /*
     * Constructor de AprendizSena.
     * super(nombre, documento, salarioBase) inicializa la
     * parte heredada de Empleado. A diferencia de Vendedor y
     * Gerente, esta clase no necesita atributos propios
     * adicionales, porque el 50% se calcula directamente a
     * partir del salarioBase heredado.
     */
    public AprendizSena(String nombre, String documento, double salarioBase) {
        super(nombre, documento, salarioBase);
    }

    /*
     * @Override
     * El apoyo de sostenimiento de un aprendiz SENA equivale
     * al 50% del salario base (según la normativa vigente
     * mencionada en el enunciado). Se multiplica salarioBase
     * por 0.5 para obtener esa mitad.
     */
    @Override
    public double calcularSalario() {
        return salarioBase * 0.5;
    }
}
