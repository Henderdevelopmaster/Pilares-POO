/* Reto: agrega WhatsApp sin modificar la clase abstracta Notificacion. */
public class NotificacionWhatsApp extends Notificacion {
    public NotificacionWhatsApp(String numero, String mensaje) { super(numero, mensaje); }

    @Override
    public void enviar() {
        System.out.println("Enviando WhatsApp a " + destinatario + ": " + mensaje);
        registrarEnvio();
    }
}
