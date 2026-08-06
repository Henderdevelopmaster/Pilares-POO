/*
-------------------------------------------------------
Clase: MainEmpresa

Punto de entrada del programa de nómina. Aquí se crean un
Vendedor y un Gerente, y se demuestra que mostrarInfo()
(definido una sola vez en Empleado) funciona correctamente
para ambos, mostrando el salario correcto de cada uno
gracias al polimorfismo.
-------------------------------------------------------
*/
public class MainEmpresa {

    public static void main(String[] args) {

        // Se crean dos objetos en memoria: un Vendedor y un
        // Gerente. Cada "new" ejecuta la cadena de
        // constructores: primero el de Empleado (vía super),
        // y luego el propio de cada hija.
        Vendedor v = new Vendedor("Ana Lopez", "1234", 1500000, 350000);
        Gerente g = new Gerente("Pedro Ruiz", "5678", 3000000, 800000);

        // AprendizSena: objeto agregado como parte del RETO DE
        // ANDAMIAJE del Ejercicio 2. Nótese que, aunque tiene
        // una regla de pago propia (50% del salario base),
        // sigue siendo un Empleado y se crea de la misma forma.
        AprendizSena a = new AprendizSena("Luis Mora", "9012", 1200000);

        // mostrarInfo() está definido SOLO en Empleado, pero
        // funciona perfecto aquí porque, internamente, llama
        // a calcularSalario(), y Java ejecuta la versión
        // sobrescrita según el tipo real de cada objeto
        // (Vendedor, Gerente o AprendizSena). Esto responde la
        // pregunta de reflexión del taller: con solo tres
        // líneas nuevas (la clase AprendizSena) se agregó un
        // rol completo a la nómina, sin tocar Empleado,
        // Vendedor ni Gerente.
        v.mostrarInfo();

        System.out.println("---");

        g.mostrarInfo();

        System.out.println("---");

        a.mostrarInfo();

        /*
         * SALIDA ESPERADA EN CONSOLA:
         *
         * Empleado: Ana Lopez
         * Documento: 1234
         * Salario a pagar: $1850000.0
         * ---
         * Empleado: Pedro Ruiz
         * Documento: 5678
         * Salario a pagar: $3800000.0
         * ---
         * Empleado: Luis Mora
         * Documento: 9012
         * Salario a pagar: $600000.0
         */
    }
}
