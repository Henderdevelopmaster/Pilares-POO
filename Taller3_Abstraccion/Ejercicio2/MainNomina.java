/* Main: crea objetos concretos y muestra el polimorfismo de la clase abstracta. */
public class MainNomina {
    public static void main(String[] args) {
        // new reserva memoria y ejecuta el constructor de cada empleado.
        EmpleadoFijo fijo = new EmpleadoFijo("Ana Rios", "1111", 2200000);
        EmpleadoPorHoras horas = new EmpleadoPorHoras("Luis Mora", "2222", 80, 15000);
        EmpleadoFreelance freelance = new EmpleadoFreelance("Sofia Perez", "3333", 3, 500000);

        fijo.mostrarRecibo();
        System.out.println("---");
        horas.mostrarRecibo();
        System.out.println("---");
        freelance.mostrarRecibo();
    }
}
