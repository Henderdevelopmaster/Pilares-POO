package Encapsulamiento.Taller1.Ejercicio1;

public class MainCuenta {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("001-2345", "Carlos Perez");
        CuentaBancaria cuenta2 = new CuentaBancaria("002-9876", "Ana Gomez");

        cuenta1.depositar(500000);

        System.out.println("Saldo cuenta1 antes: $" + cuenta1.getSaldo());
        System.out.println("Saldo cuenta2 antes: $" + cuenta2.getSaldo());

        cuenta1.transferir(cuenta2, 200000);       // Debe funcionar
        cuenta1.transferir(cuenta2, 1000000);      // Debe fallar: saldo insuficiente
        cuenta1.transferir(cuenta2, -500);         // Debe fallar: cantidad negativa

        System.out.println("Saldo cuenta1 despues: $" + cuenta1.getSaldo());
        System.out.println("Saldo cuenta2 despues: $" + cuenta2.getSaldo());
    }
}