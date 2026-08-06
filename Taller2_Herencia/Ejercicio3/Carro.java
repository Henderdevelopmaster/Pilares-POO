/*
-------------------------------------------------------
Clase: Carro

Representa un vehículo de tipo carro. Un Carro ES UN
Vehiculo (extends Vehiculo), y además tiene un atributo
propio: el número de puertas.
-------------------------------------------------------
*/
public class Carro extends Vehiculo {

    private int numeroPuertas; // Cantidad de puertas del carro

    /*
     * Constructor de Carro.
     * super(marca, modelo, precio) construye la parte común
     * heredada de Vehiculo. Después se asigna el atributo
     * propio numeroPuertas.
     */
    public Carro(String marca, String modelo, double precio, int puertas) {
        super(marca, modelo, precio);
        this.numeroPuertas = puertas;
    }

    /*
     * @Override
     * Aquí NO reemplazamos por completo el comportamiento del
     * padre: lo REUTILIZAMOS con super.describir() y luego
     * agregamos información extra. Esta técnica combina lo
     * mejor de ambos mundos: no se repite código, y la hija
     * puede extender el comportamiento heredado.
     *
     * super.describir(): "super" aquí no es un constructor,
     * sino una llamada directa al método describir() tal
     * como está definido en la clase padre Vehiculo, saltando
     * la versión sobrescrita de esta misma clase (evitando
     * así una llamada infinita a sí mismo).
     */
    @Override
    public void describir() {
        super.describir(); // Reutiliza el metodo del padre
        System.out.println("Tipo: Carro - " + numeroPuertas + " puertas");
    }
}
