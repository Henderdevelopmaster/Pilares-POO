/*
-------------------------------------------------------
Clase: Estudiante

Representa a un usuario con rol de estudiante. Un
Estudiante ES UN Usuario (extends Usuario), y además
guarda cuántos cursos tiene inscritos.
-------------------------------------------------------
*/
public class Estudiante extends Usuario {

    private int cursosInscritos; // Cantidad de cursos en los que está inscrito el estudiante

    /*
     * Constructor de Estudiante.
     * super(nombre, correo) construye la parte común
     * heredada de Usuario, y luego se guarda el número de
     * cursos, propio de esta clase.
     */
    public Estudiante(String nombre, String correo, int cursos) {
        super(nombre, correo);
        this.cursosInscritos = cursos;
    }

    /*
     * @Override
     * Sobrescribimos iniciarSesion(), pero sin descartar el
     * comportamiento del padre: primero llamamos a
     * super.iniciarSesion() para mostrar el saludo genérico
     * ("Bienvenido, nombre"), y luego agregamos información
     * específica del rol de estudiante (sus cursos
     * disponibles). Esto refleja cómo la herencia permite
     * EXTENDER un comportamiento común, no solo reemplazarlo.
     */
    @Override
    public void iniciarSesion() {
        super.iniciarSesion(); // Saludo del padre
        System.out.println("Tienes " + cursosInscritos +
                " cursos disponibles para estudiar.");
    }
}
