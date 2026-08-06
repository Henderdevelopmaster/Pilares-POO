/*
-------------------------------------------------------
Clase: MainPlataforma

Punto de entrada del programa. Crea un Estudiante y un
Instructor, y ejecuta iniciarSesion() en cada uno para
comprobar que el saludo común del padre se combina
correctamente con la pantalla específica de cada rol.
-------------------------------------------------------
*/
public class MainPlataforma {

    public static void main(String[] args) {

        // Se crean dos objetos de tipos distintos, ambos
        // hijos de Usuario. Cada uno reserva su propio
        // espacio en memoria con los datos heredados (nombre,
        // correo) más sus atributos propios.
        Estudiante e = new Estudiante("Carlos Vega",
                "carlos@sena.edu.co", 5);
        Instructor i = new Instructor("Marta Soto",
                "marta@sena.edu.co", "Java");

        // Administrador: objeto agregado como parte del RETO
        // DE ANDAMIAJE del Ejercicio 5. Extiende de Usuario
        // igual que Estudiante e Instructor, y sigue el mismo
        // patrón de reutilizar el saludo con super.iniciarSesion().
        Administrador ad = new Administrador("Julian Rincon",
                "julian@sena.edu.co", "TOTAL");

        // e.iniciarSesion() ejecuta la versión sobrescrita en
        // Estudiante, que primero saluda (heredado del padre)
        // y luego añade la información de los cursos.
        e.iniciarSesion();

        System.out.println("---");

        // i.iniciarSesion() ejecuta la versión sobrescrita en
        // Instructor, con el mismo patrón pero mostrando el
        // panel de instructor en vez de los cursos.
        i.iniciarSesion();

        System.out.println("---");

        // ad.iniciarSesion() sigue el mismo patrón: saludo
        // heredado del padre + panel propio del administrador.
        // Esto responde la pregunta de reflexión del taller:
        // agregar el rol Administrador solo requirió una
        // clase nueva, sin modificar Usuario, Estudiante ni
        // Instructor.
        ad.iniciarSesion();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Bienvenido, Carlos Vega
         * Tienes 5 cursos disponibles para estudiar.
         * ---
         * Bienvenido, Marta Soto
         * Panel del instructor de Java listo. Revisa tus estudiantes.
         * ---
         * Bienvenido, Julian Rincon
         * Panel de administracion con permisos: TOTAL
         */
    }
}
