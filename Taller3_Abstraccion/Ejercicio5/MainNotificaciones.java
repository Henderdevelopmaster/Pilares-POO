/* Main: cada clase concreta aplica el mismo metodo enviar() a su canal. */
public class MainNotificaciones {
    public static void main(String[] args) {
        NotificacionEmail email = new NotificacionEmail("carlos@sena.edu.co", "Su matricula fue aprobada.");
        NotificacionSMS sms = new NotificacionSMS("3001234567", "Su pedido esta en camino.");
        NotificacionWhatsApp whatsapp = new NotificacionWhatsApp("3107654321", "Su factura esta disponible.");

        email.enviar();
        System.out.println("---");
        sms.enviar();
        System.out.println("---");
        whatsapp.enviar();
    }
}
