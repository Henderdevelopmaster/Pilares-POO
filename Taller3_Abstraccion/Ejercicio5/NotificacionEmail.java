/* NotificacionEmail implementa el envio por correo electronico. */
public class NotificacionEmail extends Notificacion {
    public NotificacionEmail(String correo, String mensaje) { super(correo, mensaje); }

    @Override
    public void enviar() {
        System.out.println("Enviando EMAIL a " + destinatario);
        System.out.println("Asunto: Notificacion del sistema");
        System.out.println("Mensaje: " + mensaje);
        registrarEnvio();
    }
}
