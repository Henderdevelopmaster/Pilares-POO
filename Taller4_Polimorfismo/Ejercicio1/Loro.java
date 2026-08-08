/* Reto: el bucle no cambia porque Loro tambien es un Animal. */
public class Loro extends Animal {
    public Loro(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() { System.out.println(nombre + ": Hola, hola, hola!"); }
}
