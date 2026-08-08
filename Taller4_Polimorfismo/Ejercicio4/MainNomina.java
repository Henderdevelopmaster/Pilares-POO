/* Main: el mismo for calcula cada salario mediante polimorfismo dinamico. */
public class MainNomina {
    public static void main(String[] args) {
        Empleado[] nomina = {
            new EmpleadoTiempoCompleto("Ana", 2500000),
            new EmpleadoTiempoCompleto("Luis", 3100000),
            new EmpleadoFreelance("Sofia", 4, 800000),
            new EmpleadoFreelance("Carlos", 2, 1200000),
            new EmpleadoPorHoras("Marta", 80, 15000),
            new EmpleadoPorHoras("Pedro", 40, 20000)
        };
        double totalNomina = 0;
        for (Empleado empleado : nomina) {
            double pago = empleado.calcularSalario();
            System.out.println(empleado.getNombre() + ": $" + pago);
            totalNomina += pago;
        }
        System.out.println("TOTAL NOMINA: $" + totalNomina);
    }
}
