/* Bus sobrescribe mover y tiene el metodo propio abrirPuertas. */
public class Bus extends Vehiculo {
    public Bus(String placa) { super(placa); }
    @Override
    public void mover() { System.out.println("Bus " + placa + " avanza con 40 pasajeros a 60 km/h."); }
    public void abrirPuertas() { System.out.println("Bus " + placa + ": puertas abiertas."); }
}
