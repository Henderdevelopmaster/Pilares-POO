/*
-------------------------------------------------------
Clase: MainVeterinaria

Esta es la clase principal (contiene el método main), que
es el punto de entrada del programa. Aquí es donde Java
comienza a ejecutar las instrucciones.

El propósito de este archivo es crear objetos Perro y Gato,
y demostrar en la práctica cómo funciona la herencia: los
métodos heredados (comer, dormir) funcionan igual para
ambos, mientras que hacerSonido() se comporta distinto
porque fue sobrescrito en cada hija, y además cada uno
tiene su método propio (perseguirCola, ronronear).
-------------------------------------------------------
*/
public class MainVeterinaria {

    // El método main() es especial: es el que la máquina
    // virtual de Java (JVM) busca y ejecuta primero cuando
    // corremos el programa. "public static void main(String[] args)"
    // es la firma obligatoria para que Java lo reconozca como
    // punto de entrada.
    public static void main(String[] args) {

        // "new" es la palabra reservada que le pide a Java
        // que reserve espacio en memoria para un objeto nuevo
        // y ejecute su constructor. Aquí se crean dos objetos:
        // uno de tipo Perro y otro de tipo Gato.
        //
        // Qué ocurre en memoria: Java reserva un espacio en el
        // "heap" (memoria dinámica) para guardar los atributos
        // nombre y edad de cada objeto. La variable "firulais"
        // y "michi" guardan una referencia (una especie de
        // dirección) hacia ese espacio en memoria, no el
        // objeto en sí.
        Perro firulais = new Perro("Firulais", 4);
        Gato michi = new Gato("Michi", 2);

        // Pajaro: objeto agregado como parte del RETO DE
        // ANDAMIAJE del Ejercicio 1. Al igual que Perro y
        // Gato, se crea con "new" y ejecuta primero el
        // constructor de Animal (vía super) y luego el suyo.
        Pajaro piolin = new Pajaro("Piolin", 1);

        // firulais.comer(): este método NO está definido en
        // Perro, así que Java sube en la jerarquía y ejecuta
        // la versión heredada de Animal.
        firulais.comer(); // Heredado del padre

        // firulais.hacerSonido(): aquí SÍ existe una versión
        // propia en Perro (sobrescrita con @Override), así
        // que se ejecuta esa versión y no la del padre.
        firulais.hacerSonido(); // Sobrescrito

        // perseguirCola() solo existe en Perro, por eso solo
        // los objetos de tipo Perro pueden llamarlo.
        firulais.perseguirCola(); // Propio de Perro

        // presentarse() está definido solo en Animal (reto
        // extra), pero funciona igual para cualquier hija
        // porque usa los atributos heredados nombre, especie
        // y edad.
        firulais.presentarse();

        System.out.println("---");

        // Mismo patrón aplicado a Gato: dormir() se hereda,
        // hacerSonido() está sobrescrito, y ronronear() es
        // exclusivo de esta clase.
        michi.dormir(); // Heredado del padre
        michi.hacerSonido(); // Sobrescrito
        michi.ronronear(); // Propio de Gato
        michi.presentarse();

        System.out.println("---");

        // Pajaro reutiliza comer() y dormir() del padre, tiene
        // su propio hacerSonido() sobrescrito, su método
        // propio volar(), y también hereda presentarse().
        piolin.comer(); // Heredado del padre
        piolin.hacerSonido(); // Sobrescrito
        piolin.volar(); // Propio de Pajaro
        piolin.presentarse();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Firulais esta comiendo.
         * Firulais dice: Guau guau!
         * Firulais persigue su cola.
         * Soy Firulais, un Perro de 4 años.
         * ---
         * Michi esta durmiendo.
         * Michi dice: Miau!
         * Michi ronronea felizmente.
         * Soy Michi, un Gato de 2 años.
         * ---
         * Piolin esta comiendo.
         * Piolin dice: Pio pio!
         * Piolin vuela por el cielo.
         * Soy Piolin, un Pajaro de 1 años.
         */
    }
}
