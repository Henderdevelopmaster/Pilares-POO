/*
-------------------------------------------------------
Clase: PersonalIPS

Esta clase representa a cualquier persona que trabaja en
la IPS (Institución Prestadora de Salud). Reúne los datos
comunes a todo el personal: documento, nombre y salario
base, además de dos comportamientos compartidos:
registrarAsistencia() y calcularSalarioMensual().

Es la clase padre de Medico, Enfermero y Administrativo.
Cada una de esas clases hijas SÍ es un PersonalIPS, pero
cada una calcula su salario de forma distinta según su rol.

Nota pedagógica: este archivo desarrolla el Reto
Integrador propuesto al final del taller, siguiendo
exactamente la misma estructura y convenciones usadas en
los ejercicios anteriores (atributos protected, uso de
super(), sobrescritura con @Override).
-------------------------------------------------------
*/
public class PersonalIPS {

    // protected: se usa para que Medico, Enfermero y
    // Administrativo puedan acceder directamente a estos
    // datos heredados, igual que en los ejercicios previos.
    protected String documento;   // Número de identificación del trabajador
    protected String nombre;      // Nombre completo del trabajador
    protected double salarioBase; // Salario base antes de cualquier bonificación

    /*
     * Constructor de PersonalIPS.
     * Inicializa los tres datos comunes a todo el personal.
     * Se ejecuta directamente o mediante super() desde una
     * clase hija.
     */
    public PersonalIPS(String documento, String nombre, double salarioBase) {
        this.documento = documento;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    /*
     * calcularSalarioMensual()
     * Para qué sirve: da un valor "por defecto" del salario,
     * equivalente solo al salario base. Cada hija sobrescribe
     * este método para aplicar su propia regla de pago
     * (consultas, turno nocturno, etc.).
     * Qué devuelve: un double con el salario calculado.
     */
    public double calcularSalarioMensual() {
        return salarioBase;
    }

    /*
     * registrarAsistencia()
     * Para qué sirve: representa la acción de marcar
     * asistencia al llegar a trabajar. Este comportamiento es
     * exactamente igual para todo el personal (médico,
     * enfermero o administrativo), por eso NO necesita
     * sobrescribirse en ninguna hija: se queda igual en el
     * padre y todas las hijas lo heredan tal cual.
     */
    public void registrarAsistencia() {
        System.out.println(nombre + " registro su asistencia.");
    }

    /*
     * mostrarInfo()
     * Para qué sirve: imprime los datos del trabajador junto
     * con su salario ya calculado.
     * Detalle importante: aunque vive en el padre, cuando lo
     * llama un objeto Medico, Enfermero o Administrativo, la
     * línea calcularSalarioMensual() ejecuta la versión
     * sobrescrita correspondiente, gracias al polimorfismo.
     */
    public void mostrarInfo() {
        System.out.println("Trabajador: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Salario mensual: $" + calcularSalarioMensual());
    }
}
