/* Reto: salario calculado como horas trabajadas por tarifa. */
public class EmpleadoPorHoras extends Empleado {
    private int horas;
    private double tarifa;
    public EmpleadoPorHoras(String nombre, int horas, double tarifa) {
        super(nombre); this.horas = horas; this.tarifa = tarifa;
    }
    @Override
    public double calcularSalario() { return horas * tarifa; }
}
