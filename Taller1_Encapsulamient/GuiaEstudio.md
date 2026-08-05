# Guía de Estudio — Taller 1: Encapsulamiento

Este documento reúne las preguntas de reflexión ("Activa tu mente") y los retos
de andamiaje de cada ejercicio, separados del código, para que los trabajes en
tu cuaderno **antes** de mirar la solución en los archivos `.java`.

El código de cada ejercicio ya está resuelto (tal como lo entregó el
instructor) en su respectiva carpeta. El método `transferir()` del Ejercicio 1
también está resuelto porque ya lo trabajamos juntos. **Los demás retos de
andamiaje (Ejercicios 2, 3, 4 y 5) están señalados con un comentario dentro del
código pero SIN resolver** — son los que te corresponde construir a ti.

---

## Ejercicio 1: Cuenta Bancaria de Bancolombia

### Activa tu mente
1. ¿Qué pasaría si el atributo `saldo` fuera público? ¿Un empleado deshonesto
   podría cambiarlo?
2. ¿Dónde debería estar la lógica que valida si hay saldo suficiente para
   retirar: dentro de la clase o en el código que la usa?
3. Si el banco cambia mañana la regla y permite descubierto de $50.000,
   ¿cuántos archivos tendrías que modificar si el saldo es público?

### Reto de andamiaje — ✅ RESUELTO
Agregar `transferir(CuentaBancaria destino, double cantidad)` que retire de
esta cuenta y deposite en la cuenta destino, validando cantidad positiva y
saldo suficiente. Ya está en `CuentaBancaria.java` y probado en `MainCuenta.java`.

---

## Ejercicio 2: Aprendiz del SENA

### Activa tu mente
1. Si un instructor por error escribe una nota de 7.5, ¿tu programa debe
   aceptarla o rechazarla?
2. ¿Es mejor mostrar un mensaje de error o cambiar silenciosamente el valor?
3. ¿Por qué los setters son tan importantes en este ejercicio?

### Reto de andamiaje — ⬜ PENDIENTE (para ti)
Añadir un atributo privado `correoInstitucional` con su getter y setter. El
setter debe validar que el correo contenga el símbolo `@` antes de asignarlo.

**Pista:** usa `correo.contains("@")`.

**Cómo probarlo:** en `MainAprendiz.java`, intenta asignar un correo sin `@`
(debe rechazarse) y uno válido como `laura.gomez@sena.edu.co` (debe aceptarse).

---

## Ejercicio 3: Inventario de una Tienda

### Activa tu mente
1. ¿Qué pasaría si en el main alguien escribe `producto.stock = -50` sin
   encapsulamiento?
2. ¿La validación del stock debería estar en el método `vender`, o repetirse
   en cada parte del código que venda?
3. ¿Por qué es útil que el constructor use los setters para inicializar el
   precio y el stock?

### Reto de andamiaje — ⬜ PENDIENTE (para ti)
Agregar dos métodos:
- `aplicarDescuento(double porcentaje)`: reduce el precio según el porcentaje
  indicado, rechazando porcentajes fuera del rango 0-100.
- `hayStock()`: devuelve `true` si el stock es mayor a 0.

**Cómo probarlo:** en `MainProducto.java`, simula un descuento del 15% y
luego verifica si hay stock disponible con `hayStock()`.

---

## Ejercicio 4: Vehículo de Transporte

### Activa tu mente
1. ¿Debería la clase `Vehiculo` conocer el valor máximo de velocidad, o
   debería recibirlo desde fuera cada vez?
2. ¿Qué ventaja tiene declarar `VEL_MAX` como `private static final`?
3. Si mañana el gobierno cambia el límite máximo a 180 km/h, ¿dónde lo
   cambiarías?

### Reto de andamiaje — ⬜ PENDIENTE (para ti)
Añadir un atributo privado `kilometrajeTotal` (double). Cada vez que el
vehículo acelera, sumarle `velocidad / 100` al kilometraje (simulación
simple). Añadir un getter y mostrarlo al final en el main.

**Extra:** crear un método `reset()` que ponga la velocidad en 0.

---

## Ejercicio 5: Autenticación Segura de Usuario

### Activa tu mente
1. Si existiera un `getPassword()`, ¿qué riesgos habría?
2. ¿Por qué la validación (`esPasswordValida`) es privada y no pública?
3. ¿Cómo verificamos entonces si un intento de login es correcto, sin exponer
   la contraseña?

### Reto de andamiaje — ⬜ PENDIENTE (para ti)
Añadir un contador privado `intentosFallidos`. Cada vez que
`verificarPassword` devuelva `false`, aumentar el contador. Cuando llegue a 3
intentos fallidos, la cuenta debe bloquearse (atributo `boolean bloqueado`).
Cuando esté bloqueada, `verificarPassword` debe devolver siempre `false`.

**Cómo probarlo:** en `MainUsuario.java`, simula 3 intentos fallidos seguidos
y verifica que el cuarto intento (aunque la clave sea correcta) también falle
por estar bloqueada.

---

## Reto Integrador: Historia Clínica de una IPS — ⬜ PENDIENTE (para ti)

Este no tiene solución guiada — lo diseñas completo tú mismo aplicando todo
lo aprendido en los 5 ejercicios.

### Activa tu mente
1. ¿Qué pasa si un desarrollador crea un `getDiagnostico()` público? ¿Se
   violaría la ley de protección de datos (Ley 1581 de 2012)?
2. ¿Qué otros atributos deberían ser privados con setters validados?
3. ¿Cómo garantizas que la clave del médico no aparezca en logs o mensajes?

### Requisitos de la clase `Paciente`
- Atributos: `documento`, `nombre`, `edad` (0-120), `tipoSangre` (solo A+, A-,
  B+, B-, O+, O-, AB+, AB-).
- Atributo privado `diagnostico` **sin getter público**.
- Método `consultarDiagnostico(String claveMedico)`: solo devuelve el
  diagnóstico si la clave coincide con `"MED-2026"`.
- Método `actualizarDiagnostico(...)`: solo funciona si la clave es correcta.
- Método `tieneAlergias()`.
- Atributo `alergias` (arreglo de `String`) con un método para agregarlas.

### `MainIPS.java` debe:
1. Crear un paciente.
2. Intentar consultar el diagnóstico con una clave incorrecta.
3. Consultar con la clave correcta.
4. Agregar 2 alergias.
5. Mostrar toda la información pública del paciente.

---

## Cierre metacognitivo — para responder en tu cuaderno

1. Con tus propias palabras, ¿qué es el encapsulamiento? (evita repetir la
   definición del libro).
2. ¿En qué ejercicio sentiste que el encapsulamiento se justificaba más
   claramente? ¿Por qué?
3. Menciona un ejemplo de tu vida cotidiana donde funcione el mismo principio
   del encapsulamiento.
4. Si tuvieras que explicarle el encapsulamiento a un compañero que faltó a
   clase, ¿qué analogía usarías?
5. ¿Qué duda te quedó? Anótala para consultarla con tu instructor.

---

## Orden de estudio sugerido

1. Lee la situación problema del ejercicio en el PDF original.
2. Responde las preguntas de "Activa tu mente" en tu cuaderno **sin mirar el
   código**.
3. Abre el archivo `.java` correspondiente y compáralo con lo que pensaste.
4. Compílalo y ejecútalo (`MainX.java`) para ver el comportamiento real.
5. Intenta resolver el reto de andamiaje pendiente tú mismo, usando el
   comentario `NOTA PARA ESTUDIO` como recordatorio de dónde va.
6. Solo si te trabas, pide ayuda puntual — no la solución completa de una vez.
