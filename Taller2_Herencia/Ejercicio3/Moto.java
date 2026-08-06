/*
-------------------------------------------------------
Clase: Moto

Representa un vehículo de tipo moto. Una Moto ES UN
Vehiculo (extends Vehiculo), con un atributo propio: el
cilindraje del motor.
-------------------------------------------------------
*/
public class Moto extends Vehiculo {

    private int cilindraje; // Capacidad del motor, medida en centímetros cúbicos (cc)

    /*
     * Constructor de Moto. Igual que en Carro, primero se
     * inicializa la parte común con super(...), y después el
     * atributo propio cilindraje.
     */
    public Moto(String marca, String modelo, double precio, int cilindraje) {
        super(marca, modelo, precio);
        this.cilindraje = cilindraje;
    }

    /*
     * @Override
     * Mismo patrón que en Carro: se reutiliza describir() del
     * padre con super.describir(), y luego se agrega el dato
     * específico de la moto (el cilindraje). Esto demuestra
     * que distintas hijas pueden extender el mismo método del
     * padre de formas diferentes.
     */
    @Override
    public void describir() {
        super.describir();
        System.out.println("Tipo: Moto - " + cilindraje + " cc");
    }
}
