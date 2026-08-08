/* Padre de reservas: define datos comunes y la operacion que todas calculan. */
public class Reserva {
    protected String cliente;
    public Reserva(String cliente) { this.cliente = cliente; }
    public double calcularPrecio() { return 0; }
    public String getCliente() { return cliente; }
}
