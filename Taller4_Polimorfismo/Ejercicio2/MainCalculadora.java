/* Main: las llamadas prueban las seis firmas sobrecargadas. */
public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println("2 + 3 = " + calculadora.sumar(2, 3));
        System.out.println("1 + 2 + 3 = " + calculadora.sumar(1, 2, 3));
        System.out.println("2.5 + 3.7 = " + calculadora.sumar(2.5, 3.7));
        System.out.println("Hola + Mundo = " + calculadora.sumar("Hola", "Mundo"));
        System.out.println("2 + 3.5 = " + calculadora.sumar(2, 3.5));
        System.out.println("Arreglo = " + calculadora.sumar(new int[] { 1, 2, 3, 4 }));
    }
}
