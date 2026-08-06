/*
-------------------------------------------------------
Clase: Vendedor

Representa a un empleado del área comercial. Un Vendedor
ES UN Empleado (extends Empleado), pero además gana una
comisión por ventas, algo que ningún otro tipo de empleado
tiene.
-------------------------------------------------------
*/
public class Vendedor extends Empleado {

    // private: a diferencia de los atributos del padre, este
    // atributo es exclusivo de Vendedor y no necesita ser
    // visto por ninguna otra clase hija, por eso se usa
    // private en vez de protected.
    private double comision; // Dinero adicional ganado por ventas realizadas

    /*
     * Constructor de Vendedor.
     * super(nombre, documento, salarioBase) inicializa la
     * parte heredada de Empleado. Luego, this.comision
     * guarda el valor propio de esta clase. super() SIEMPRE
     * debe ser la primera línea del constructor.
     */
    public Vendedor(String nombre, String documento,
                     double salarioBase, double comision) {
        super(nombre, documento, salarioBase);
        this.comision = comision;
    }

    /*
     * @Override
     * Sobrescribimos calcularSalario() porque un Vendedor NO
     * gana solamente el salario base (como dice la versión
     * del padre): gana salario base + comisión. Cuando
     * mostrarInfo() (heredado de Empleado) llame a
     * calcularSalario(), Java usará automáticamente ESTA
     * versión para los objetos Vendedor.
     */
    @Override
    public double calcularSalario() {
        return salarioBase + comision;
    }
}
