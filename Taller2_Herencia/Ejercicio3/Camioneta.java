/*
-------------------------------------------------------
Clase: Camioneta

Esta clase resuelve el RETO DE ANDAMIAJE del Ejercicio 3:
"Añade una tercera hija Camioneta con un atributo
capacidadCarga (en kg). Su método describir() debe llamar
a super.describir() y agregar 'Tipo: Camioneta - X kg de
carga'."

Una Camioneta ES UN Vehiculo (extends Vehiculo), con un
atributo propio: la capacidad de carga que puede
transportar, medida en kilogramos.
-------------------------------------------------------
*/
public class Camioneta extends Vehiculo {

    private int capacidadCarga; // Capacidad máxima de carga de la camioneta, en kilogramos (kg)

    /*
     * Constructor de Camioneta.
     * super(marca, modelo, precio) construye la parte
     * heredada de Vehiculo, y luego se asigna el atributo
     * propio capacidadCarga.
     */
    public Camioneta(String marca, String modelo, double precio, int capacidadCarga) {
        super(marca, modelo, precio);
        this.capacidadCarga = capacidadCarga;
    }

    /*
     * @Override
     * Mismo patrón usado en Carro y Moto: se reutiliza el
     * método describir() del padre con super.describir(), y
     * luego se agrega la información específica de esta
     * clase (la capacidad de carga). Esto confirma que la
     * técnica de extender un método heredado funciona igual
     * sin importar cuántas hijas nuevas se agreguen.
     */
    @Override
    public void describir() {
        super.describir();
        System.out.println("Tipo: Camioneta - " + capacidadCarga + " kg de carga");
    }
}
