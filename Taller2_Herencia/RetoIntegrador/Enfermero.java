/*
-------------------------------------------------------
Clase: Enfermero

Representa a un enfermero de la IPS. Un Enfermero ES UN
PersonalIPS (extends PersonalIPS), con un atributo propio:
el turno en el que trabaja (mañana, tarde o noche), ya que
el turno noche paga una bonificación adicional.
-------------------------------------------------------
*/
public class Enfermero extends PersonalIPS {

    private String turno; // Jornada de trabajo: "manana", "tarde" o "noche"

    /*
     * Constructor de Enfermero.
     * super(documento, nombre, salarioBase) construye la
     * parte heredada de PersonalIPS, y luego se guarda el
     * turno, propio de esta clase.
     */
    public Enfermero(String documento, String nombre, double salarioBase, String turno) {
        super(documento, nombre, salarioBase);
        this.turno = turno;
    }

    /*
     * @Override
     * Un enfermero gana su salario base, y si su turno es
     * "noche", recibe $200.000 adicionales. Se usa un if para
     * comparar el texto del turno con equals() (en Java, para
     * comparar el CONTENIDO de dos String se usa equals(),
     * no el operador ==, que compara referencias en memoria).
     */
    @Override
    public double calcularSalarioMensual() {
        if (turno.equals("noche")) {
            return salarioBase + 200000;
        } else {
            return salarioBase;
        }
    }
}
