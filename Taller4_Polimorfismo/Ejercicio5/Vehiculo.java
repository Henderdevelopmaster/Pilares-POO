/* Padre de la flota: define placa y movimiento comun. */
public class Vehiculo {
    protected String placa;
    public Vehiculo(String placa) { this.placa = placa; }
    public void mover() { System.out.println("El vehiculo " + placa + " se mueve."); }
    public String getPlaca() { return placa; }
}
