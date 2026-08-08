/* Main: recorre reservas mezcladas y usa instanceof solo para la capacidad propia del vuelo. */
public class MainAgencia {
    public static void main(String[] args) {
        Reserva[] reservas = {
            new ReservaVuelo("Ana", false, 500),
            new ReservaVuelo("Luis", true, 4200),
            new ReservaHotel("Sofia", 3, 180000),
            new ReservaBusIntermunicipal("Carlos", "Cucuta", "Bucaramanga", 90000),
            new ReservaHotel("Marta", 2, 220000)
        };
        double total = 0;
        for (Reserva reserva : reservas) {
            double precio = reserva.calcularPrecio();
            System.out.println(reserva.getCliente() + ": $" + precio);
            total += precio;
            if (reserva instanceof ReservaVuelo) {
                ReservaVuelo vuelo = (ReservaVuelo) reserva;
                System.out.println("Vuelo internacional: " + vuelo.esInternacional());
            }
        }
        System.out.println("TOTAL DEL CARRITO: $" + total);
    }
}
