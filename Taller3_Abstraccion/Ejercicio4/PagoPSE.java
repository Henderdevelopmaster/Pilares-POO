/* PagoPSE simula la redireccion bancaria y la confirmacion del pago. */
public class PagoPSE extends MedioPago {
    private String banco;

    public PagoPSE(double monto, String banco) {
        super(monto);
        this.banco = banco;
    }

    @Override
    public void procesarPago() {
        System.out.println("Redireccionando al banco " + banco + "...");
        System.out.println("Esperando confirmacion del banco...");
        System.out.println("Pago PSE aprobado por " + banco + ".");
    }
}
