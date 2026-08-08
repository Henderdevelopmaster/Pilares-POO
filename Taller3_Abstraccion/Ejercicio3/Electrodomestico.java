/* Clase abstracta: concentra estado y comportamientos comunes del hogar. */
public abstract class Electrodomestico {
    protected String marca;
    protected boolean encendido;

    public Electrodomestico(String marca) {
        this.marca = marca;
        this.encendido = false; // Todo objeto inicia apagado.
    }

    public void encender() {
        encendido = true;
        System.out.println(marca + " esta encendido.");
    }

    public void apagar() {
        encendido = false;
        System.out.println(marca + " esta apagado.");
    }

    // Cada hija debe implementar la funcion que la hace particular.
    public abstract void funcionPrincipal();
}
