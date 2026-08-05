public class MainUsuario {
    public static void main(String[] args) {
        Usuario u = new Usuario("carlos.dev", "clave1234");

        System.out.println("Usuario: " + u.getNombreUsuario());

        u.cambiarPassword("hola"); // Invalida

        System.out.println("Login OK? " + u.verificarPassword("clave1234"));
        System.out.println("Login mal? " + u.verificarPassword("otra"));

        u.cambiarPassword("nuevaClave9");
        System.out.println("Login nuevo? " + u.verificarPassword("nuevaClave9"));
    }
}
