/* Vaca representa otra implementacion del sonido polimorfico. */
public class Vaca extends Animal {
    public Vaca(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() { System.out.println(nombre + ": Muuu!"); }
}
