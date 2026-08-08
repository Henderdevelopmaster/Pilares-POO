/* TarjetaCredito valida y cobra usando el monto heredado. */
public class TarjetaCredito extends MedioPago {
    private String numeroTarjeta;

    public TarjetaCredito(double monto, String numeroTarjeta) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago() {
        System.out.println("Validando tarjeta " + numeroTarjeta + "...");
        System.out.println("Cobrando $" + monto + " a la tarjeta.");
        System.out.println("Pago aprobado.");
    }
}
