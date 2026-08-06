/*
-------------------------------------------------------
Clase: Animal

Esta clase representa el concepto general de un animal
dentro del sistema de la veterinaria "Amigos Peludos".

Se utiliza como CLASE PADRE (también llamada superclase o
clase base). Su función es reunir todo lo que TODOS los
animales tienen en común: un nombre, una edad, y la
capacidad de comer y dormir.

Gracias a la herencia (extends), las clases hijas como
Perro y Gato no necesitan volver a escribir este código.
Ellas simplemente "heredan" estos atributos y métodos y
los reutilizan.

Relación con la herencia:
Animal es el punto de partida de la jerarquía. Es la clase
más general. Las clases hijas serán versiones más
específicas (especializadas) de un Animal.
-------------------------------------------------------
*/
public class Animal {

    // ---------------------------------------------------
    // ATRIBUTOS
    // ---------------------------------------------------

    // protected: este modificador de acceso permite que el
    // atributo sea visible tanto dentro de esta clase como
    // dentro de cualquier clase hija (Perro, Gato, etc.).
    // Si usáramos "private", las clases hijas NO podrían
    // acceder directamente a "nombre" y "edad", y tendríamos
    // que crear métodos getter/setter para todo. Como
    // queremos que las hijas usen estos datos libremente
    // (por ejemplo, para armar el mensaje del sonido),
    // usamos protected.
    protected String nombre;  // Guarda el nombre propio del animal (ej: "Firulais")
    protected int edad;       // Guarda la edad del animal en años (ej: 4)

    // especie: atributo agregado como parte del RETO EXTRA del
    // taller. Guarda a qué especie pertenece el animal (ej:
    // "Perro", "Gato", "Pajaro"). Es protected por la misma
    // razón que nombre y edad: las clases hijas lo necesitan
    // para poder mostrarlo en presentarse().
    protected String especie; // Guarda la especie del animal (ej: "Perro")

    // ---------------------------------------------------
    // CONSTRUCTOR
    // ---------------------------------------------------

    /*
     * Constructor de Animal.
     *
     * Un constructor es un método especial que se ejecuta
     * automáticamente cada vez que se crea un objeto nuevo
     * con la palabra "new". Su trabajo es dejar el objeto
     * listo para usarse, inicializando sus atributos.
     *
     * Este constructor en particular se ejecuta:
     *  - Directamente, cuando alguien escribe: new Animal(...)
     *  - Indirectamente, cuando una clase hija (Perro, Gato,
     *    Pajaro) llama a super(nombre, edad, especie) desde
     *    su propio constructor. En ese caso, Java primero
     *    construye la "parte Animal" del objeto antes de
     *    continuar con la parte específica de la hija.
     *
     * Nota: se agregó el parámetro especie como parte del
     * reto extra del taller, así que todas las clases hijas
     * (Perro, Gato, Pajaro) ahora deben pasarle su especie al
     * llamar a super().
     */
    public Animal(String nombre, int edad, String especie) {
        // this.nombre se refiere al atributo de la clase.
        // "nombre" (sin this) se refiere al parámetro que
        // llega entre paréntesis. Usamos "this" para decirle
        // a Java: "guarda el valor que llegó como parámetro
        // dentro del atributo del objeto".
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    // ---------------------------------------------------
    // MÉTODOS
    // ---------------------------------------------------

    /*
     * comer()
     * Para qué sirve: representa la acción de comer, que
     * comparten TODOS los animales sin importar la especie.
     * Cuándo se utiliza: cuando alguien invoca metodoAnimal.comer()
     * desde el main o desde cualquier otra parte del programa.
     * Qué hace paso a paso: construye un mensaje con el
     * nombre del animal y lo imprime en consola.
     * Qué devuelve: nada (void), solo imprime un mensaje.
     */
    public void comer() {
        // System.out.println() envía información a la consola.
        // Es el método más utilizado para mostrar resultados
        // al usuario mientras el programa se ejecuta.
        System.out.println(nombre + " esta comiendo.");
    }

    /*
     * dormir()
     * Igual que comer(), es un comportamiento común a todos
     * los animales, por eso vive aquí, en el padre, y no se
     * repite en cada clase hija.
     */
    public void dormir() {
        System.out.println(nombre + " esta durmiendo.");
    }

    /*
     * hacerSonido()
     * Este método existe en el padre con un mensaje genérico,
     * pero está pensado para ser SOBRESCRITO (@Override) por
     * cada clase hija, ya que cada especie hace un sonido
     * distinto (el perro ladra, el gato maúlla). Aquí solo
     * dejamos un comportamiento por defecto.
     */
    public void hacerSonido() {
        System.out.println(nombre + " emite un sonido.");
    }

    /*
     * presentarse()
     * Método agregado como parte del RETO EXTRA del taller.
     * Para qué sirve: muestra en consola un resumen con el
     * nombre, la especie y la edad del animal, usando los
     * tres atributos heredados por todas las hijas. Como este
     * método vive en el padre, Perro, Gato y Pajaro lo
     * heredan automáticamente sin escribir una sola línea
     * adicional, cumpliendo otra vez el principio DRY (Don't
     * Repeat Yourself).
     * Qué devuelve: nada (void), solo imprime un mensaje.
     */
    public void presentarse() {
        System.out.println("Soy " + nombre + ", un " + especie + " de " + edad + " años.");
    }
}
