/* Gato sobrescribe el mismo metodo con su comportamiento. */
public class Gato extends Animal {
    public Gato(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() { System.out.println(nombre + ": Miau!"); }
}
