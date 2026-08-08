/* Reto: MotoTaxi agrega un comportamiento propio para recoger pasajeros. */
public class MotoTaxi extends Vehiculo {
    public MotoTaxi(String placa) { super(placa); }
    @Override
    public void mover() { System.out.println("MotoTaxi " + placa + " avanza por la ciudad."); }
    public void recogerPasajero() { System.out.println("MotoTaxi " + placa + ": pasajero recogido."); }
}
