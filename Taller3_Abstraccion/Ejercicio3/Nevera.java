/* Nevera: implementa la funcion abstracta enfriando alimentos. */
public class Nevera extends Electrodomestico {
    public Nevera(String marca) { super(marca); }

    @Override
    public void funcionPrincipal() {
        if (encendido) {
            System.out.println("Enfriando alimentos a 4 grados C...");
        } else {
            System.out.println("Enciendala primero.");
        }
    }
}
