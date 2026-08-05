public class Usuario {

    private String nombreUsuario;
    private String password; // Nunca tendra getter publico

    public Usuario(String nombreUsuario, String passwordInicial) {
        this.nombreUsuario = nombreUsuario;
        cambiarPassword(passwordInicial);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void cambiarPassword(String nueva) {
        if (esPasswordValida(nueva)) {
            this.password = nueva;
            System.out.println("Contrasena actualizada correctamente.");
        } else {
            System.out.println("Contrasena invalida: min 8 caracteres " +
                    "y al menos un numero.");
        }
    }

    public boolean verificarPassword(String intento) {
        return this.password != null && this.password.equals(intento);
    }

    private boolean esPasswordValida(String pass) {
        if (pass == null || pass.length() < 8) return false;
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    // ==========================================================
    // NOTA PARA ESTUDIO: reto de andamiaje pendiente:
    // contador intentosFallidos + atributo boolean bloqueado
    // Todavia no resuelto - ver GuiaEstudio.md
    // ==========================================================
}
