/*
-------------------------------------------------------
Clase: Vehiculo

Representa cualquier vehículo que se vende en la
concesionaria. Reúne los datos comunes a todos: marca,
modelo y precio, y define un método describir() básico
que las hijas van a REUTILIZAR (no solo sobrescribir desde
cero) usando super.describir().
-------------------------------------------------------
*/
public class Vehiculo {

    protected String marca;  // Fabricante del vehículo (ej: "Chevrolet")
    protected String modelo; // Nombre del modelo (ej: "Spark")
    protected double precio; // Precio de venta en pesos

    /*
     * Constructor de Vehiculo. Inicializa los tres datos
     * comunes a cualquier vehículo. Se ejecuta directamente
     * o mediante super(...) desde una clase hija.
     */
    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /*
     * describir()
     * Para qué sirve: imprime la información básica común a
     * todo vehículo (marca, modelo y precio).
     * Por qué es clave para la herencia: las clases hijas NO
     * van a reescribir esta lógica; en cambio, la van a
     * invocar con super.describir() y luego añadir su propia
     * información específica encima. Esto evita duplicar
     * código.
     */
    public void describir() {
        System.out.println(marca + " " + modelo + " - $" + precio);
    }
}
