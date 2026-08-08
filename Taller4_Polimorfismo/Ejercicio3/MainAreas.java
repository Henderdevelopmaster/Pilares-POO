/* Main: el arreglo Figura[] contiene objetos de varias clases hijas. */
public class MainAreas {
    public static Figura encontrarMayorArea(Figura[] figuras) {
        Figura mayor = figuras[0];
        for (Figura figura : figuras) {
            if (figura.calcularArea() > mayor.calcularArea()) { mayor = figura; }
        }
        return mayor;
    }

    public static void main(String[] args) {
        Figura[] figuras = {
            new Cuadrado(4), new Circulo(3), new Triangulo(5, 6),
            new Rectangulo(3, 8), new Rectangulo(10, 2)
        };
        double areaTotal = 0;
        for (Figura figura : figuras) {
            double area = figura.calcularArea();
            System.out.println("Area parcial: " + area);
            areaTotal += area;
        }
        System.out.println("AREA TOTAL: " + areaTotal);
        System.out.println("MAYOR AREA: " + encontrarMayorArea(figuras).calcularArea());
    }
}
