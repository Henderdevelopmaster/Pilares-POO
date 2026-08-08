/* Lavadora: reto de andamiaje; agrega una funcion principal y un metodo propio. */
public class Lavadora extends Electrodomestico {
    public Lavadora(String marca) { super(marca); }

    @Override
    public void funcionPrincipal() {
        if (encendido) {
            System.out.println("Lavando ropa a 40 grados C durante 45 minutos");
        } else {
            System.out.println("Enciendala primero.");
        }
    }

    // Este comportamiento es propio de Lavadora, no del padre.
    public void centrifugar() {
        System.out.println("La lavadora esta centrifugando.");
    }
}
