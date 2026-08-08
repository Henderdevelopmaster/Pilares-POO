/* Main: prueba el estado comun y las funciones particulares de tres aparatos. */
public class MainHogar {
    public static void main(String[] args) {
        Televisor tv = new Televisor("LG");
        Nevera nevera = new Nevera("Samsung");
        Lavadora lavadora = new Lavadora("Haceb");

        tv.encender();
        tv.funcionPrincipal();
        System.out.println("---");
        nevera.funcionPrincipal(); // if detecta que aun esta apagada.
        nevera.encender();
        nevera.funcionPrincipal();
        System.out.println("---");
        lavadora.encender();
        lavadora.funcionPrincipal();
        lavadora.centrifugar();
    }
}
