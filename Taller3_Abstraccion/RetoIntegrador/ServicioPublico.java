/*
Clase abstracta del reto. Define datos compartidos y obliga a calcularFactura().
No puede instanciarse porque un servicio generico no tiene una tarifa concreta.
*/
public abstract class ServicioPublico {
    protected String numeroContrato;
    protected String titular;
    protected double consumo;

    public ServicioPublico(String numeroContrato, String titular, double consumo) {
        this.numeroContrato = numeroContrato;
        this.titular = titular;
        this.consumo = consumo;
    }

    public abstract double calcularFactura();

    // Metodo concreto reutilizable: calcula dinamicamente la factura de la hija.
    public void emitirRecibo() {
        System.out.println("Contrato: " + numeroContrato);
        System.out.println("Titular: " + titular);
        System.out.println("Consumo: " + consumo);
        System.out.println("Total a pagar: $" + calcularFactura());
    }
}
