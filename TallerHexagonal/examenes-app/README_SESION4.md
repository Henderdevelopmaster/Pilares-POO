# Sesion 4: JWT y Spring Security

## Requisitos previos

Instala JDK 21, ten MySQL corriendo en `localhost:3306` y crea la base vacia:

```sql
CREATE DATABASE examenes_app;
```

En `src/main/resources/application.properties` deja la URL, usuario y puerto
locales. Cambia solamente `TU_CLAVE_MYSQL` por la clave real de tu usuario MySQL.
No se suben claves reales al repositorio.

Al agregar `spring-boot-starter-security`, Spring bloquea inicialmente todos los
endpoints con un login generico. Es normal: `SecurityConfig` y el filtro JWT son
los que cambian ese comportamiento.

## Compilar y ejecutar

Desde esta carpeta:

```bash
./gradlew build
./gradlew bootRun
```

En Windows también puedes usar `gradlew.bat`. La API escucha en el puerto 8080.

## Ocho pruebas

Usa una terminal con la aplicación ejecutándose. Guarda los tokens en las
variables `TOKEN` y `ADMIN_TOKEN` según corresponda.

1. Registrar usuario:

```bash
curl -i -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d "{\"username\":\"ana\",\"email\":\"ana@sena.edu.co\",\"password\":\"Secreta123\"}"
```

2. Login correcto:

```bash
curl -s -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d "{\"username\":\"ana\",\"password\":\"Secreta123\"}"
```

En PowerShell: `$TOKEN = (curl.exe -s ... | ConvertFrom-Json).token`.

3. Login con password mala (espera 401):

```bash
curl -i -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d "{\"username\":\"ana\",\"password\":\"mala\"}"
```

4. Login con usuario inexistente (espera 401 y el mismo mensaje):

```bash
curl -i -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d "{\"username\":\"nadie\",\"password\":\"mala\"}"
```

5. GET sin token (espera 401):

```bash
curl -i http://localhost:8080/api/usuarios/ana
```

6. GET con token (espera 200):

```bash
curl -i http://localhost:8080/api/usuarios/ana -H "Authorization: Bearer $TOKEN"
```

7. POST de rol sin ADMIN (espera 403):

```bash
curl -i -X POST http://localhost:8080/api/roles -H "Authorization: Bearer $TOKEN" -H "Content-Type: application/json" -d "{\"nombre\":\"APRENDIZ\",\"descripcion\":\"Usuario aprendiz\"}"
```

8. POST de rol con ADMIN (espera 201). Primero crea un usuario admin desde el
endpoint de la Sesion 3 y obtén su token:

```bash
curl -i -X POST http://localhost:8080/api/usuarios -H "Content-Type: application/json" -d "{\"username\":\"admin\",\"email\":\"admin@sena.edu.co\",\"password\":\"Admin123\"}"
curl -s -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d "{\"username\":\"admin\",\"password\":\"Admin123\"}"
curl -i -X POST http://localhost:8080/api/usuarios/admin/roles/ADMIN -H "Authorization: Bearer $TOKEN"
```

Guarda el token obtenido del login de `admin` como `ADMIN_TOKEN` y ejecuta:

```bash
curl -i -X POST http://localhost:8080/api/roles -H "Authorization: Bearer $ADMIN_TOKEN" -H "Content-Type: application/json" -d "{\"nombre\":\"ADMIN\",\"descripcion\":\"Administrador\"}"
```

## Problemas comunes

- Si todo devuelve 401, revisa que `SecurityConfig` esté completo y que el
  header sea exactamente `Authorization: Bearer TOKEN`.
- Si MySQL no conecta, confirma que el servicio esté activo, que exista
  `examenes_app` y que la clave en `application.properties` sea correcta.
- Si Gradle falla resolviendo JJWT, verifica internet y usa la versión 0.12.7
  en las tres dependencias (`api`, `impl` y `jackson`).

## Para el despliegue de mañana

Antes de subir a un servidor, externaliza la URL de la base de datos, el usuario
y la clave de MySQL mediante variables de entorno o configuración segura. En
esta versión la clave JWT se genera en memoria al arrancar y cambia en cada
reinicio. Para varias instancias o reinicios frecuentes deberá fijarse como
variable de entorno y compartirse de forma segura.
