/*
-------------------------------------------------------
Clase: Perro

Esta clase representa a un perro dentro de la veterinaria.

Un Perro ES UN Animal (relación "es un"), por eso esta
clase EXTIENDE de Animal. Extender (extends) significa que
Perro hereda automáticamente todos los atributos (nombre,
edad) y métodos (comer, dormir, hacerSonido) que ya están
definidos en la clase padre Animal, sin necesidad de
volver a escribirlos aquí.

Además de lo heredado, Perro agrega su propio
comportamiento específico: perseguirCola(), que ningún
otro animal tiene, y sobrescribe hacerSonido() para que
ladre en vez de emitir un sonido genérico.
-------------------------------------------------------
*/
public class Perro extends Animal {

    /*
     * Constructor de Perro.
     *
     * Se ejecuta cada vez que se crea un objeto Perro con
     * "new Perro(...)".
     *
     * super(nombre, edad):
     * - "super" hace referencia al constructor de la clase
     *   padre (Animal).
     * - Al llamarlo, le estamos pidiendo a Java que primero
     *   construya la parte "Animal" del objeto (que guarde
     *   nombre y edad), antes de continuar con lo específico
     *   de Perro.
     * - ¿Qué pasaría si no llamáramos a super()? En este caso
     *   Java lo llamaría automáticamente sin argumentos, pero
     *   como Animal no tiene un constructor vacío, el código
     *   NO compilaría. Por eso es obligatorio llamarlo aquí
     *   con los parámetros correctos.
     */
    public Perro(String nombre, int edad) {
        // Se le pasa "Perro" como especie fija al padre, ya
        // que un objeto Perro siempre pertenece a esa especie.
        // Esto forma parte del reto extra del Ejercicio 1
        // (atributo especie + método presentarse() en Animal).
        super(nombre, edad, "Perro"); // Llama al constructor del padre
    }

    /*
     * @Override
     * Esta anotación le indica a Java (y a cualquier
     * programador que lea el código) que este método está
     * REEMPLAZANDO la versión que ya existía en la clase
     * padre Animal.
     *
     * Sobrescribir significa: la clase hija define su propia
     * versión de un método heredado, porque el comportamiento
     * genérico del padre no le sirve. Aquí, en lugar de
     * "emite un sonido" (el mensaje genérico de Animal),
     * el Perro va a ladrar.
     *
     * Diferencia con el método original: el método original
     * en Animal imprimía un mensaje genérico. Esta versión
     * imprime un mensaje específico de la especie perro.
     * Cuando se llama firulais.hacerSonido(), Java ejecuta
     * ESTA versión, no la del padre, porque el objeto real es
     * un Perro.
     */
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Guau guau!");
    }

    /*
     * perseguirCola()
     * Método propio de Perro, no existe en la clase padre.
     * Representa un comportamiento exclusivo de esta especie.
     * Para qué sirve: mostrar que las clases hijas pueden
     * tener funcionalidades adicionales, además de lo
     * heredado.
     */
    public void perseguirCola() {
        System.out.println(nombre + " persigue su cola.");
    }
}
