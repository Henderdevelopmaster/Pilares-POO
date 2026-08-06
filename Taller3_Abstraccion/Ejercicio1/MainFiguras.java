package Ejercicio1;

public class MainFiguras {
    public static void main(String[] args) {
// Figura f = new Figura("X"); ERROR: no se puede instanciar
        Circulo c = new Circulo(5);
        Triangulo t = new Triangulo(4, 6);
        Rectangulo r = new Rectangulo(5,10);
        Cuadrado u = new Cuadrado(5);
        c.mostrar();
        System.out.println("---");
        t.mostrar();
        r.mostrar();
        u.mostrar();
    }
}