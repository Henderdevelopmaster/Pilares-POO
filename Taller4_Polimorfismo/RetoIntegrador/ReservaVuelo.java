/* Vuelo: precio distancia por 500 mas tarifa base; conserva si es internacional. */
public class ReservaVuelo extends Reserva {
    private boolean internacional;
    private double distanciaKm;
    public ReservaVuelo(String cliente, boolean internacional, double distanciaKm) {
        super(cliente); this.internacional = internacional; this.distanciaKm = distanciaKm;
    }
    @Override
    public double calcularPrecio() { return distanciaKm * 500 + 150000; }
    public boolean esInternacional() { return internacional; }
}
