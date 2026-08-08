/* Padre: todos los empleados tienen nombre y pueden calcular salario. */
public class Empleado {
    protected String nombre;
    public Empleado(String nombre) { this.nombre = nombre; }
    public double calcularSalario() { return 0; }
    public String getNombre() { return nombre; }
}
