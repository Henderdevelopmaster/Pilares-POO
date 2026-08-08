/* Padre: una referencia Animal puede apuntar a cualquier animal hijo. */
public class Animal {
    protected String nombre;

    public Animal(String nombre) { this.nombre = nombre; }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido generico.");
    }
}
