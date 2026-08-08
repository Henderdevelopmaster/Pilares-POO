/* Perro sobrescribe el sonido heredado. */
public class Perro extends Animal {
    public Perro(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() { System.out.println(nombre + ": Guau guau!"); }
}
