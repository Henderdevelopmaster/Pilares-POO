/* Main: emite tres recibos y demuestra que cada hija aplica su tarifa. */
public class MainServicios {
    public static void main(String[] args) {
        Agua agua = new Agua("AG-001", "Ana Rios", 15);
        Luz luz = new Luz("LU-002", "Luis Mora", 250);
        Gas gas = new Gas("GA-003", "Sofia Perez", 12);

        agua.emitirRecibo();
        System.out.println("---");
        luz.emitirRecibo();
        System.out.println("---");
        gas.emitirRecibo();
    }
}
