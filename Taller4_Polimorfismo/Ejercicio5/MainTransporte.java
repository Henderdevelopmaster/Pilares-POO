/* Main: instanceof verifica el tipo real y el casting habilita metodos propios. */
public class MainTransporte {
    public static void main(String[] args) {
        Vehiculo[] flota = {
            new Bus("BUS-001"), new Taxi("TAX-555"), new Bicicleta("BIC-777"),
            new Bus("BUS-002"), new MotoTaxi("MTX-101"), new MotoTaxi("MTX-202")
        };
        for (Vehiculo vehiculo : flota) {
            vehiculo.mover();
            if (vehiculo instanceof Bus) {
                Bus bus = (Bus) vehiculo; // casting: trata la referencia como Bus.
                bus.abrirPuertas();
            }
            if (vehiculo instanceof MotoTaxi) {
                MotoTaxi motoTaxi = (MotoTaxi) vehiculo;
                motoTaxi.recogerPasajero();
            }
        }
    }
}
