# Demo para EasyDevel

### Requerimientos
- Java 17

### Entorno de desarrollo local
En el directorio servers se puede encontrar un fichero `docker-compose.yml`,
que levanta los siguientes servicios:

- Redis
- PostgreSQL

Para generar la tabla en la que se basa la demo en postgress se ha agregado el fichero
`schema.sql`:

```sql
DROP TABLE IF EXISTS t_section;
CREATE TABLE t_section (
id SERIAL,
nombre varchar(255) NOT NULL,
PRIMARY KEY ("id")
)
```

### Configuraciones para diferentes entornos
Se han creado dos ficheros de configuración para el entorno local (`application.yml`) y para
staging (`application-staging.yml`).

### Documentación
Se ha agregado Swagger al proyecto para poder documentar y probar la API desde el navegador
accediendo a la siguiente url: http://localhost:8080/doc/swagger-ui.html

![Swagger image](/swagger_example.png)
