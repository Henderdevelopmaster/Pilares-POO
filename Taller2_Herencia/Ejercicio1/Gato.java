/*
-------------------------------------------------------
Clase: Gato

Representa a un gato dentro de la veterinaria. Al igual
que Perro, un Gato ES UN Animal, por lo que EXTIENDE de
la clase Animal y hereda nombre, edad, comer() y dormir()
sin tener que reescribirlos.

Gato sobrescribe hacerSonido() para maullar, y agrega su
propio método ronronear(), que es exclusivo de esta
especie.
-------------------------------------------------------
*/
public class Gato extends Animal {

    /*
     * Constructor de Gato.
     * Se ejecuta al hacer "new Gato(...)".
     *
     * super(nombre, edad) llama al constructor de Animal
     * para que se inicialicen correctamente los atributos
     * heredados (nombre y edad). Esto siempre debe ser la
     * primera instrucción del constructor de la hija.
     */
    public Gato(String nombre, int edad) {
        // Se le pasa "Gato" como especie fija al padre. Esto
        // forma parte del reto extra del Ejercicio 1 (atributo
        // especie + método presentarse() agregados en Animal).
        super(nombre, edad, "Gato");
    }

    /*
     * @Override: aquí sobrescribimos el comportamiento de
     * hacerSonido() heredado de Animal. En vez del sonido
     * genérico del padre, el gato maúlla. Esto es posible
     * gracias al polimorfismo: cada hija puede dar su propia
     * versión de un método que originalmente vino del padre.
     */
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Miau!");
    }

    /*
     * ronronear()
     * Método propio de Gato. No existe en Animal ni en Perro.
     * Cada clase hija puede tener comportamientos que solo
     * ella posee, además de lo que comparte con sus
     * "hermanas" por medio del padre.
     */
    public void ronronear() {
        System.out.println(nombre + " ronronea felizmente.");
    }
}
