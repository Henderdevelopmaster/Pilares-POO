/* Main: los tres objetos responden al mismo contrato con procesos distintos. */
public class MainTienda {
    public static void main(String[] args) {
        TarjetaCredito tarjeta = new TarjetaCredito(250000, "4111-2222-3333-4444");
        PagoEfectivo efectivo = new PagoEfectivo(80000);
        PagoPSE pse = new PagoPSE(175000, "Bancolombia");

        tarjeta.mostrarMonto();
        tarjeta.procesarPago();
        System.out.println("---");
        efectivo.mostrarMonto();
        efectivo.procesarPago();
        System.out.println("---");
        pse.mostrarMonto();
        pse.procesarPago();
    }
}
