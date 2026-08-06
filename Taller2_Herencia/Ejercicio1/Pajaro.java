/*
-------------------------------------------------------
Clase: Pajaro

Esta clase resuelve el RETO DE ANDAMIAJE del Ejercicio 1:
"Crea una tercera clase hija Pajaro que también extienda
de Animal. Debe sobrescribir hacerSonido() con el mensaje
'Pio pio!' y agregar un método propio volar()."

Un Pajaro ES UN Animal (extends Animal), por lo que hereda
nombre, edad, especie, comer(), dormir() y presentarse()
sin tener que reescribirlos. Solo sobrescribe hacerSonido()
y agrega su propio comportamiento: volar().
-------------------------------------------------------
*/
public class Pajaro extends Animal {

    /*
     * Constructor de Pajaro.
     * super(nombre, edad, "Pajaro") construye la parte
     * heredada de Animal, incluyendo la especie fija
     * "Pajaro", necesaria para que presentarse() (heredado
     * del padre) muestre el mensaje correcto sin que esta
     * clase tenga que sobrescribirlo.
     */
    public Pajaro(String nombre, int edad) {
        super(nombre, edad, "Pajaro");
    }

    /*
     * @Override
     * Igual que Perro y Gato, cada especie sobrescribe
     * hacerSonido() con su propio sonido característico. En
     * este caso, el pájaro canta "Pio pio!".
     */
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Pio pio!");
    }

    /*
     * volar()
     * Método propio de Pajaro, no existe en Animal ni en las
     * demás hijas (Perro, Gato). Representa un comportamiento
     * exclusivo de esta especie, demostrando que cada clase
     * hija puede tener funcionalidades que solo ella posee.
     */
    public void volar() {
        System.out.println(nombre + " vuela por el cielo.");
    }
}
