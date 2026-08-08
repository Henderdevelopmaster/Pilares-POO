/* Main: el tipo declarado Animal oculta el tipo concreto hasta tiempo de ejecucion. */
public class MainCoro {
    public static void main(String[] args) {
        Animal[] animales = {
            new Perro("Firulais"), new Gato("Michi"), new Vaca("Lola"),
            new Loro("Paco"), new Loro("Lola")
        };

        // for recorre el arreglo; Java usa la version sobrescrita de cada objeto.
        for (Animal animal : animales) {
            animal.hacerSonido();
        }
    }
}
