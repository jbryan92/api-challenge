<h1 style="text-align: left;">MURCIFILES</h1>

   ![murchivador](https://github.com/user-attachments/assets/5d887780-9365-4f7e-9f76-101a58a8aa58)


<h1 style="font-size: 24px; font-weight: bold;">Forohub_API</h1>

Un foro para Topicos con su respectivo token de seguridad.



\## 📁 Acceso al proyecto: 

El proyecto se encontrara en github en el link brindado, encontrara todas
las carpetas necesarias para hacer los registros correspondientes



\## 🛠️ Abre y ejecuta el proyecto:

>[!NOTE]
Para verificar la utilidad del proyecto se tiene que dar "Run"


Este proyecto se aplican las prácticas para construir y proteger una API Rest. A continuación, se detalla lo que se ha implementado...

## Contenido del Challenge

### 1. Reorganización de Paquetes

El proyecto se estructura en tres paquetes principales:

-   **Controller**: Contiene los controladores, que son los puntos de entrada a la API.
-   **Domain**: Define el dominio del problema, incluyendo las entidades JPA como Topico y Usuario.
-   **Infra**: Relacionado con el *framework* y las bibliotecas utilizadas en el proyecto.

### 2. Estandarización de Respuestas del Controlador

Se modificó el `MedicoController` para estandarizar las respuestas, utilizando `ResponseEntity` para devolver códigos de estado HTTP adecuados y encabezados de ubicación.

-   **Ejemplo**: El método de registro devuelve un `Created` (201) con la URI del nuevo recurso.

### 3. Operaciones CRUD

-   **Listar Topicos Activos**: Devuelve un 200 con una lista paginada de médicos activos.
-   **Eliminar Topico**: Envía un 204 ("No Content") para indicar una eliminación exitosa.

### 4. Gestión de Errores con `RestControllerAdvice`

Se creó un gestor de errores global para interceptar excepciones y devolver respuestas de error estandarizadas.

-   **`EntityNotFoundException`**: Devuelve un 404 ("Not Found") si no se encuentra una entidad.
-   **`MethodArgumentNotValidException`**: Devuelve un 400 ("Bad Request") con detalles sobre los errores de validación.

### 5. Autenticación y Generación de Tokens JWT

Se implementó un sistema de autenticación basado en tokens JWT (JSON Web Tokens).

-   **Inicio de Sesión**: Recibe un DTO con las credenciales, autentica al usuario y genera un token JWT.
-   **`TokenService`**: Clase encargada de la generación y validación de tokens JWT utilizando la biblioteca *Auth0JWT*.

### 6. Configuración de Seguridad

Se configuró la seguridad de la aplicación utilizando `SecurityFilterChain`.

-   Se deshabilitó el CSRF (Cross-Site Request Forgery) debido a que la API es *stateless*.
-   Se definieron políticas de autorización para los endpoints.
-   Se añadió un filtro de seguridad personalizado (`SecurityFilter`) para validar los tokens JWT en cada petición.

### 7. Uso de Bcrypt para el Hashing de Contraseñas

Se utilizó la biblioteca Bcrypt para realizar el *hashing* de las contraseñas de los usuarios antes de almacenarlas en la base de datos.

### 8. Detalles del Usuario y Repositorio

-   Se implementó la interfaz `UserDetails` en la clase `Usuario` para integrar la autenticación con Spring Security.
-   Se creó un `UsuarioRepository` para gestionar los usuarios en la base de datos.
-   Se implementó un `AutenticacionService` que implementa la interfaz `UserDetailsService` para cargar los detalles del usuario durante la autenticación.



## Contribuciones 🖇️
este proyecto fue contribuido por:  


<img width="253" height="163" alt="para el challenge" src="https://github.com/user-attachments/assets/f93da19b-3fdb-47a5-bcd3-fdecc5e2ba2e" />



## Autores ✒️
| [<img src="https://github.com/user-attachments/assets/a06186be-9579-49f3-8b64-930e41b5b345" width=115><br><sub>Jbryan Guevara</sub>]([https://github.com/jbryan92]) |
| :---: | 
