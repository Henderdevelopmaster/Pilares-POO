/* NotificacionSMS implementa el envio a un numero celular. */
public class NotificacionSMS extends Notificacion {
    public NotificacionSMS(String celular, String mensaje) { super(celular, mensaje); }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS al numero " + destinatario);
        System.out.println("SMS: " + mensaje);
        registrarEnvio();
    }
}
