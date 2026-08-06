/*
-------------------------------------------------------
Clase: Gerente

Representa a un empleado con cargo directivo. Un Gerente
ES UN Empleado (extends Empleado), pero en vez de comisión
recibe una bonificación fija.
-------------------------------------------------------
*/
public class Gerente extends Empleado {

    private double bonificacion; // Monto fijo adicional que recibe el gerente

    /*
     * Constructor de Gerente. Al igual que en Vendedor, la
     * primera línea llama a super(...) para construir la
     * parte común (Empleado), y luego se inicializa el
     * atributo propio bonificacion.
     */
    public Gerente(String nombre, String documento,
                    double salarioBase, double bonificacion) {
        super(nombre, documento, salarioBase);
        this.bonificacion = bonificacion;
    }

    /*
     * @Override
     * Cada tipo de empleado calcula su salario a su manera.
     * Aquí, un Gerente gana salario base + bonificación fija.
     * Esta es la esencia del polimorfismo: el mismo nombre de
     * método (calcularSalario) se comporta distinto según el
     * tipo real del objeto.
     */
    @Override
    public double calcularSalario() {
        return salarioBase + bonificacion;
    }
}
