/*
-------------------------------------------------------
Clase: Instructor

Representa a un usuario con rol de instructor. Un
Instructor ES UN Usuario (extends Usuario), y además
guarda su especialidad, es decir, el área que enseña.
-------------------------------------------------------
*/
public class Instructor extends Usuario {

    private String especialidad; // Área o tecnología que enseña el instructor (ej: "Java")

    /*
     * Constructor de Instructor.
     * super(nombre, correo) inicializa la parte heredada de
     * Usuario, y luego se guarda la especialidad, propia de
     * esta clase.
     */
    public Instructor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    /*
     * @Override
     * Igual que en Estudiante, reutilizamos el saludo del
     * padre con super.iniciarSesion(), y luego mostramos
     * información propia del rol de instructor: su panel de
     * trabajo según su especialidad.
     */
    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("Panel del instructor de " + especialidad +
                " listo. Revisa tus estudiantes.");
    }
}
