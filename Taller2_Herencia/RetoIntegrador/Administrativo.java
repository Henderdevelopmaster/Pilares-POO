/*
-------------------------------------------------------
Clase: Administrativo

Representa a un trabajador del área administrativa de la
IPS (recepción, facturación, etc.). Un Administrativo ES UN
PersonalIPS (extends PersonalIPS), con un atributo propio:
el área en la que trabaja.
-------------------------------------------------------
*/
public class Administrativo extends PersonalIPS {

    private String area; // Área administrativa donde trabaja (ej: "Facturacion")

    /*
     * Constructor de Administrativo.
     * super(documento, nombre, salarioBase) inicializa la
     * parte heredada, y luego se guarda el área, propia de
     * esta clase.
     */
    public Administrativo(String documento, String nombre, double salarioBase, String area) {
        super(documento, nombre, salarioBase);
        this.area = area;
    }

    /*
     * @Override
     * Un administrativo gana únicamente el salario base, sin
     * bonificaciones adicionales. Aunque el resultado es
     * igual al del método del padre, se sobrescribe de todas
     * formas para dejar explícito que esta es la regla de
     * pago propia de este rol, y para mantener la coherencia
     * con el resto de clases hijas.
     */
    @Override
    public double calcularSalarioMensual() {
        return salarioBase;
    }
}
