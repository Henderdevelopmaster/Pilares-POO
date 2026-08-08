/* Freelance cobra proyectos entregados por pago de cada proyecto. */
public class EmpleadoFreelance extends Empleado {
    private int proyectos;
    private double pagoPorProyecto;
    public EmpleadoFreelance(String nombre, int proyectos, double pago) {
        super(nombre); this.proyectos = proyectos; this.pagoPorProyecto = pago;
    }
    @Override
    public double calcularSalario() { return proyectos * pagoPorProyecto; }
}
