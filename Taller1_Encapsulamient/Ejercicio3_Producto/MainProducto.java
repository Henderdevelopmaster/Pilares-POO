public class MainProducto {
    public static void main(String[] args) {
        Producto p = new Producto("P-001", "Teclado Mecanico", 180000, 10);

        System.out.println("Producto: " + p.getNombre());
        System.out.println("Precio: $" + p.getPrecio());
        System.out.println("Stock: " + p.getStock());

        p.vender(3);
        p.vender(20); // Debe fallar
        p.reabastecer(5);

        System.out.println("Stock final: " + p.getStock());
    }
}
