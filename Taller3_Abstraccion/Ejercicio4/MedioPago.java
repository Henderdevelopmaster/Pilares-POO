/* Clase abstracta: define que todo medio tiene monto y debe procesar un pago. */
public abstract class MedioPago {
    protected double monto;

    public MedioPago(double monto) {
        this.monto = monto;
    }

    // Metodo sin cuerpo: cada medio debe explicar su proceso.
    public abstract void procesarPago();

    public void mostrarMonto() {
        System.out.println("Monto a pagar: $" + monto);
    }
}
