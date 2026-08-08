/* Hotel: precio calculado por noches y precio unitario de cada noche. */
public class ReservaHotel extends Reserva {
    private int noches;
    private double precioPorNoche;
    public ReservaHotel(String cliente, int noches, double precioPorNoche) {
        super(cliente); this.noches = noches; this.precioPorNoche = precioPorNoche;
    }
    @Override
    public double calcularPrecio() { return noches * precioPorNoche; }
}
