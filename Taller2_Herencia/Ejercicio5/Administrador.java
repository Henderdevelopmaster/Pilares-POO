/*
-------------------------------------------------------
Clase: Administrador

Esta clase resuelve el RETO DE ANDAMIAJE del Ejercicio 5:
"Añade una tercera clase hija Administrador con un
atributo nivelPermiso (String: 'TOTAL' o 'PARCIAL'). Su
iniciarSesion() debe llamar al padre y luego mostrar:
'Panel de administracion con permisos: [nivelPermiso]'."

Un Administrador ES UN Usuario (extends Usuario), con un
atributo propio: su nivel de permisos dentro de la
plataforma.
-------------------------------------------------------
*/
public class Administrador extends Usuario {

    private String nivelPermiso; // Nivel de acceso del administrador: "TOTAL" o "PARCIAL"

    /*
     * Constructor de Administrador.
     * super(nombre, correo) construye la parte heredada de
     * Usuario, y luego se guarda el nivel de permiso, propio
     * de esta clase.
     */
    public Administrador(String nombre, String correo, String nivelPermiso) {
        super(nombre, correo);
        this.nivelPermiso = nivelPermiso;
    }

    /*
     * @Override
     * Igual que Estudiante e Instructor, primero se reutiliza
     * el saludo genérico del padre con super.iniciarSesion(),
     * y luego se agrega la información propia del rol: el
     * panel de administración con su nivel de permisos.
     */
    @Override
    public void iniciarSesion() {
        super.iniciarSesion();
        System.out.println("Panel de administracion con permisos: " + nivelPermiso);
    }
}
