/* Bicicleta implementa el movimiento de un vehiculo no motorizado. */
public class Bicicleta extends Vehiculo {
    public Bicicleta(String placa) { super(placa); }
    @Override
    public void mover() { System.out.println("Bicicleta " + placa + " es pedaleada a 20 km/h."); }
}
