/* Clase hija para un empleado con salario mensual constante. */
public class EmpleadoFijo extends Empleado {
    private double salarioMensual; // private protege el dato propio de esta clase.

    public EmpleadoFijo(String nombre, String documento, double salarioMensual) {
        super(nombre, documento); // super ejecuta el constructor de Empleado.
        this.salarioMensual = salarioMensual;
    }

    // Override sobrescribe el contrato abstracto con la formula del empleado fijo.
    @Override
    public double calcularPago() {
        return salarioMensual;
    }
}
