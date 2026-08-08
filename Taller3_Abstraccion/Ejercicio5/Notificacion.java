/* Clase abstracta que centraliza destinatario, mensaje y registro comun. */
public abstract class Notificacion {
    protected String destinatario;
    protected String mensaje;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public abstract void enviar();

    // Las hijas llaman este metodo despues del envio real.
    public void registrarEnvio() {
        System.out.println("[LOG] Notificacion enviada a: " + destinatario);
    }
}
