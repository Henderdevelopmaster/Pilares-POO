/* Gas cobra 2.100 por m3 y un cargo fijo de 5.000. */
public class Gas extends ServicioPublico {
    public Gas(String numeroContrato, String titular, double consumo) {
        super(numeroContrato, titular, consumo);
    }

    @Override
    public double calcularFactura() {
        return consumo * 2100 + 5000;
    }
}
