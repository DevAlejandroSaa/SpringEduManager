# 🎓 SpringEduManager

<p align="center">
  <strong>Sistema de gestión académica desarrollado con Spring Boot.</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 4.1.1">
  <img src="https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white" alt="MySQL 8">
  <img src="https://img.shields.io/badge/Maven-3-C71A36?logo=apachemaven&logoColor=white" alt="Maven">
</p>

## 📋 Descripción

**SpringEduManager** es una aplicación web orientada a la gestión académica de una institución educativa.

El sistema permite centralizar información relacionada con usuarios, accesos, programas académicos, cursos, prácticas y evaluaciones mediante una arquitectura basada en **Spring Boot** y una **API REST**.

## ✨ Características

* 👤 Gestión de información de usuarios.
* 🔐 Gestión de accesos y estados de acceso.
* 👥 Gestión de roles.
* 🎓 Gestión de programas académicos.
* 📚 Gestión de cursos y sus estados.
* 🏫 Gestión de ofertas académicas.
* 📝 Gestión de inscripciones y evaluaciones.
* 💼 Gestión de prácticas.
* 📊 Gestión de reglas de calificación.
* 🔎 Filtrado y paginación de información.
* 🌐 API REST versionada.

## 🛠️ Tecnologías

| Tecnología           | Versión     |
| -------------------- | ----------- |
| ☕ Java               | 17          |
| 🌱 Spring Boot       | 4.1.1       |
| 🗄️ MySQL            | 8           |
| 📦 Maven             | 3           |
| 🧩 Spring Data JPA   | Spring Boot |
| 🔒 Spring Security   | Spring Boot |
| 🗺️ MapStruct        | 1.6.3       |
| 🔎 Blaze-Persistence | —           |
| 📖 Springdoc OpenAPI | —           |

## 📋 Requisitos

Antes de ejecutar el proyecto se requiere disponer de:

* ☕ Java 17.
* 📦 Maven 3.
* 🗄️ MySQL 8.
* 🧰 Git.

Verifica las versiones instaladas:

```bash
java -version
mvn -version
mysql --version
git --version
```

## 🚀 Instalación

Clona el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```

Ingresa al directorio del proyecto:

```bash
cd edu-manager
```

Instala las dependencias y compila el proyecto:

```bash
mvn clean install
```

## ⚙️ Configuración

Configura los parámetros de conexión a la base de datos en el archivo correspondiente de Spring Boot.

Ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/edu_manager
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

> ⚠️ No almacenes credenciales reales directamente en el repositorio.

## 🗄️ Base de datos

El proyecto utiliza **MySQL 8** como sistema gestor de base de datos.

La aplicación utiliza persistencia mediante **Spring Data JPA** y Hibernate.

Antes de iniciar la aplicación, asegúrate de que la base de datos configurada se encuentre disponible.

## ▶️ Ejecución

Puedes iniciar la aplicación utilizando Maven:

```bash
mvn spring-boot:run
```

También puedes ejecutar el proyecto previamente compilado mediante:

```bash
java -jar target/edu-manager.jar
```

## 📁 Estructura del proyecto

La aplicación se organiza siguiendo una separación por responsabilidades:

```text
src/
└── main/
    ├── java/
    │   └── cl/
    │       └── edu/
    │           ├── controller/
    │           ├── core/
    │           ├── dto/
    │           ├── entity/
    │           ├── mapper/
    │           ├── repository/
    │           └── service/
    │
    └── resources/
        └── i18n/
            └── messages_es.properties
```

### 📦 Principales paquetes

| Paquete      | Responsabilidad                            |
| ------------ | ------------------------------------------ |
| `controller` | Exposición de endpoints REST               |
| `service`    | Lógica de negocio                          |
| `repository` | Acceso a datos                             |
| `entity`     | Entidades JPA                              |
| `dto`        | Objetos de transferencia de datos          |
| `mapper`     | Conversión entre entidades y DTO           |
| `core`       | Componentes transversales de la aplicación |

## 🌐 API REST

La API utiliza versionamiento mediante el prefijo:

```text
/v1/
```

Los recursos se exponen mediante endpoints REST y utilizan operaciones HTTP según la responsabilidad de cada recurso.

Entre los recursos principales se encuentran:

```text
/v1/roles/
/v1/access/
/v1/access-status/
/v1/user-information/
/v1/academic-programs/
/v1/course-status/
/v1/courses/
/v1/course-offerings/
/v1/user-courses/
/v1/course-evaluations/
/v1/course-classes/
/v1/practice-status/
/v1/practices/
/v1/user-practices/
/v1/practice-evaluations/
/v1/grade-rules/
```

## 📖 Documentación de la API

La API está preparada para integrarse con **OpenAPI/Swagger** mediante Springdoc.

Una vez iniciada la aplicación, la documentación estará disponible según la configuración de Springdoc del proyecto.

## 🔐 Seguridad

La aplicación incorpora **Spring Security** como componente de seguridad.

La gestión de acceso contempla:

* 👤 Usuarios.
* 🔑 Credenciales.
* 👥 Roles.
* 🔒 Estados de acceso.
* 🎫 Tokens de acceso y actualización.

## 🧪 Pruebas

Para ejecutar las pruebas automatizadas:

```bash
mvn test
```

Para ejecutar la compilación completa:

```bash
mvn clean verify
```

## 👨‍💻 Autor

**Alejandro Saa Silva**

Desarrollador Fullstack Java | Spring Boot

🇨🇱 Temuco, Chile

## 📄 Licencia

Este proyecto ha sido desarrollado con fines académicos y de evaluación.

---

<p align="center">
  <strong>SpringEduManager</strong>
</p>
<p align="center">
  Gestión académica mediante Spring Boot y API REST.
</p>
