/* Taxi implementa su propio movimiento. */
public class Taxi extends Vehiculo {
    public Taxi(String placa) { super(placa); }
    @Override
    public void mover() { System.out.println("Taxi " + placa + " transporta a 1 pasajero por la ciudad."); }
}
