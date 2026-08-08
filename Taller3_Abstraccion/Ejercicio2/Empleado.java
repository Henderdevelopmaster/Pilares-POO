/*
-------------------------------------------------------
Clase: Empleado

Clase abstracta que define el contrato comun de la nomina.
No se puede crear con new porque no representa una forma completa de pago;
sus clases hijas deben implementar calcularPago().
-------------------------------------------------------
*/
public abstract class Empleado {
    // protected permite que las hijas usen estos datos heredados directamente.
    protected String nombre;
    protected String documento;

    // El constructor se ejecuta al crear una hija y guarda la informacion comun.
    public Empleado(String nombre, String documento) {
        this.nombre = nombre; // this distingue el atributo del parametro.
        this.documento = documento;
    }

    // Metodo abstracto: obliga a cada hija a definir su propia formula de pago.
    public abstract double calcularPago();

    // Metodo concreto reutilizable; llama polimorficamente a calcularPago().
    public void mostrarRecibo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Pago del mes: $" + calcularPago());
    }
}
