/* Reto: rectangulo agrega ancho por alto sin cambiar el algoritmo del main. */
public class Rectangulo extends Figura {
    private double ancho;
    private double alto;
    public Rectangulo(double ancho, double alto) { this.ancho = ancho; this.alto = alto; }
    @Override
    public double calcularArea() { return ancho * alto; }
}
