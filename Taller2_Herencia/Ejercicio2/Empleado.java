/*
-------------------------------------------------------
Clase: Empleado

Representa a cualquier trabajador de la empresa. Es la
clase padre de la jerarquía de nómina: contiene todo lo
que comparten TODOS los empleados (nombre, documento y
salario base), y define un cálculo de salario por defecto
que las hijas (Vendedor, Gerente) sobrescribirán según su
propia forma de ganar dinero.

Relación con la herencia: Empleado es la base general.
Vendedor y Gerente son especializaciones que SÍ son un
Empleado, pero con reglas de pago distintas.
-------------------------------------------------------
*/
public class Empleado {

    // protected permite que Vendedor y Gerente accedan
    // directamente a estos datos sin necesidad de getters,
    // ya que forman parte de "su propia identidad" heredada.
    protected String nombre;      // Nombre completo del empleado
    protected String documento;   // Número de documento de identidad
    protected double salarioBase; // Salario base antes de comisiones o bonos

    /*
     * Constructor de Empleado.
     * Se ejecuta al crear un Empleado directamente, o de
     * forma indirecta cuando una hija llama a super(...) para
     * inicializar la parte común (nombre, documento,
     * salarioBase) antes de agregar sus propios atributos.
     */
    public Empleado(String nombre, String documento, double salarioBase) {
        this.nombre = nombre;
        this.documento = documento;
        this.salarioBase = salarioBase;
    }

    /*
     * calcularSalario()
     * Para qué sirve: define, por defecto, que un empleado
     * gana simplemente su salario base.
     * Por qué está en el padre: aunque cada hija sobrescribe
     * este método con su propia fórmula, tenerlo aquí permite
     * que el padre tenga un comportamiento "de respaldo" y
     * que mostrarInfo() pueda llamarlo sin saber de qué tipo
     * exacto de empleado se trata.
     * Qué devuelve: un valor double con el salario calculado.
     */
    public double calcularSalario() {
        return salarioBase;
    }

    /*
     * mostrarInfo()
     * Para qué sirve: imprime en consola los datos del
     * empleado, incluyendo su salario ya calculado.
     * Qué hace paso a paso:
     *  1. Imprime el nombre.
     *  2. Imprime el documento.
     *  3. Llama a calcularSalario() e imprime el resultado.
     *
     * Detalle importante: aunque este método vive en el
     * padre, cuando lo llama un objeto Vendedor o Gerente,
     * la línea calcularSalario() ejecuta la versión
     * SOBRESCRITA de la hija correspondiente, no la de aquí.
     * Esto es polimorfismo: el padre no necesita saber qué
     * hija es, Java decide en tiempo de ejecución cuál
     * versión del método usar.
     */
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Salario a pagar: $" + calcularSalario());
    }
}
