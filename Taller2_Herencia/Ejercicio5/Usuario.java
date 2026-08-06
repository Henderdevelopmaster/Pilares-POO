/*
-------------------------------------------------------
Clase: Usuario

Representa a cualquier persona registrada en la plataforma
educativa (similar a SENA Sofía Plus). Todos los usuarios,
sin importar su rol, tienen un nombre y un correo, y pueden
iniciar sesión. Esta clase es el padre de Estudiante e
Instructor.
-------------------------------------------------------
*/
public class Usuario {

    protected String nombre; // Nombre completo del usuario
    protected String correo; // Correo electrónico usado para iniciar sesión

    /*
     * Constructor de Usuario. Inicializa los datos comunes a
     * cualquier persona que use la plataforma, sin importar
     * si después resulta ser Estudiante o Instructor.
     */
    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    /*
     * iniciarSesion()
     * Para qué sirve: representa el saludo de bienvenida que
     * ve CUALQUIER usuario al entrar a la plataforma.
     * Por qué vive en el padre: es un comportamiento
     * compartido por todos los roles. Las hijas lo van a
     * reutilizar con super.iniciarSesion() y luego añadirán
     * su propia pantalla específica encima (esto se ve en
     * Estudiante e Instructor).
     */
    public void iniciarSesion() {
        System.out.println("Bienvenido, " + nombre);
    }
}
