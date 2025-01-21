<h1> ForoHub - API REST Back End</h1>

ForoHub API es una solución completa para la gestión de un foro en línea. Proporciona endpoints para la autenticación de usuarios, 
la creación y gestión de temas de discusión, y la interacción entre los usuarios a través de respuestas y comentarios. 
La API está diseñada para ser segura, eficiente y fácil de usar.

<h2>Funcionalidades</h2> 

- **Autenticación de Usuarios**: Registro y autenticación de usuarios utilizando JWT (JSON Web Tokens).
- **Gestión de Usuarios**: Creación, actualización y eliminación de usuarios.
- **Gestión de Tópicos**: Creación, actualización y eliminación de temas de discusión.
- **Gestión de Respuestas**: Publicación, actualización y eliminación de respuestas a los temas.
- **Documentación Interactiva**: Documentación de la API generada automáticamente con `springdoc-openapi` y accesible a través de Swagger UI.

<h2>Cómo Usarlo</h2>

1. Clona el repositorio:
   ```bash
   git clone https://github.com/ISosaDev/ForoHub---API-REST-Back-End.git
2. Navega al directorio del proyecto:
cd ForoHub---API-REST-Back-End

3. Configura la base de datos en el archivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/forohub_api
spring.datasource.username=miusuario_baseDeDatos
spring.datasource.password=miclave
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
server.error.include-stacktrace=never
api.security.secret=${JWT_SECRET:ContraseñaSecreta}

4. Ejecuta la aplicación:

mvn spring-boot:run

5. Accede a la documentación de la API:

La documentación interactiva de Swagger UI está disponible en:
http://localhost:8080/swagger-ui.html

<h2>Ayuda</h2> 
Si necesitas ayuda con el proyecto, puedes encontrar más información en la documentación de la API accesible a través de Swagger UI. También puedes abrir un issue en el repositorio de GitHub o contactar a los autores del proyecto.

<h2> Autor</h2>

Isael Sosa - ISosaDev
