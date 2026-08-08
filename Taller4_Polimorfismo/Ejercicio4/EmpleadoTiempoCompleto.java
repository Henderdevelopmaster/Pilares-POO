/* Empleado con salario mensual fijo. */
public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioMensual;
    public EmpleadoTiempoCompleto(String nombre, double salario) {
        super(nombre); this.salarioMensual = salario;
    }
    @Override
    public double calcularSalario() { return salarioMensual; }
}
