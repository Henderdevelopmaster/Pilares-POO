/*
-------------------------------------------------------
Clase: Medico

Representa a un médico de la IPS. Un Medico ES UN
PersonalIPS (extends PersonalIPS), con dos atributos
propios: su especialidad y la cantidad de consultas que
atendió en el mes, ya que su salario depende de ese número.
-------------------------------------------------------
*/
public class Medico extends PersonalIPS {

    private String especialidad;   // Área médica en la que se especializa (ej: "Pediatria")
    private int consultasDelMes;   // Cantidad de consultas atendidas durante el mes

    /*
     * Constructor de Medico.
     * super(documento, nombre, salarioBase) inicializa la
     * parte heredada de PersonalIPS. Luego se asignan los
     * atributos propios: especialidad y consultasDelMes.
     */
    public Medico(String documento, String nombre, double salarioBase,
                  String especialidad, int consultasDelMes) {
        super(documento, nombre, salarioBase);
        this.especialidad = especialidad;
        this.consultasDelMes = consultasDelMes;
    }

    /*
     * @Override
     * Un médico gana su salario base más $500.000 por cada
     * consulta atendida en el mes. Por eso multiplicamos
     * consultasDelMes por 500000 y lo sumamos al salario
     * base. Esta fórmula es exclusiva de Medico, ninguna otra
     * clase la usa.
     */
    @Override
    public double calcularSalarioMensual() {
        return salarioBase + (consultasDelMes * 500000);
    }
}
