/*
-------------------------------------------------------
Clase: MainIPS

Punto de entrada del Reto Integrador. Crea un Medico con
20 consultas del mes, un Enfermero del turno noche y un
Administrativo de facturación, y muestra la información de
los tres para comprobar que cada uno calcula su salario
correctamente según su propia regla de pago.
-------------------------------------------------------
*/
public class MainIPS {

    public static void main(String[] args) {

        // Se crean tres objetos de tipos distintos, todos
        // hijos de PersonalIPS. Cada "new" ejecuta primero el
        // constructor del padre (vía super) y luego el propio
        // de cada hija, reservando en memoria tanto los datos
        // heredados como los específicos de cada rol.
        Medico medico = new Medico("1001", "Dra. Laura Peña", 4500000, "Pediatria", 20);
        Enfermero enfermero = new Enfermero("1002", "Jorge Castillo", 2000000, "noche");
        Administrativo administrativo = new Administrativo("1003", "Sandra Rojas", 1800000, "Facturacion");

        // mostrarInfo() está definido solo en PersonalIPS,
        // pero funciona correctamente para los tres objetos
        // porque, internamente, llama a
        // calcularSalarioMensual(), y Java ejecuta la versión
        // sobrescrita según el tipo real de cada objeto.
        medico.mostrarInfo();
        medico.registrarAsistencia(); // Heredado del padre, igual para todos

        System.out.println("---");

        enfermero.mostrarInfo();
        enfermero.registrarAsistencia();

        System.out.println("---");

        administrativo.mostrarInfo();
        administrativo.registrarAsistencia();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Trabajador: Dra. Laura Peña
         * Documento: 1001
         * Salario mensual: $1.45E7
         * Dra. Laura Peña registro su asistencia.
         * ---
         * Trabajador: Jorge Castillo
         * Documento: 1002
         * Salario mensual: $2200000.0
         * Jorge Castillo registro su asistencia.
         * ---
         * Trabajador: Sandra Rojas
         * Documento: 1003
         * Salario mensual: $1800000.0
         * Sandra Rojas registro su asistencia.
         */
    }
}
