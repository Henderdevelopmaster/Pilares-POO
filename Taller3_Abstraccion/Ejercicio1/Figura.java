public abstract class Figura {
    protected String nombre;
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    // Metodo abstracto: las hijas DEBEN implementarlo
    public abstract double calcularArea();
    // Metodo concreto: lo heredan todas las hijas
    public void mostrar() {
        System.out.println("Figura: " + nombre);
        System.out.println("Area: " + calcularArea());
    }
}