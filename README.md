# SpringEduManager

spring boot 4.1.1

Group           cl.edu
Artifact	    edu-manager
Name	        edu-manager
Description	    Edu Manager

Java            8

Spring Initializr
    Spring Web
    Spring Data JPA
    Validation
    Spring Security
    MySQL Driver
    Lombok
    Springdoc OpenAPI — Swagger/OpenAPI

Agregar posteriormente al pom.xml
    Blaze-Persistence — filtros y consultas dinámicas
    MapStruct — mapeo Entity ↔ DTO
    JJWT — JWT para access/refresh tokens

Estructura de carpetas:

springedumanager/
│
├── controller/       → Capa MVC
├── dto/              → Entrada/salida de la API
├── entity/           → Modelo de persistencia
├── repository/       → Acceso a datos
├── service/          → Lógica de negocio
├── mapper/           → Conversión DTO ↔ Entity
├── helper/           → Componentes auxiliares
├── util/             → Utilidades generales
│
└── core/             → Componentes transversales
    ├── security/
    ├── config/
    ├── interceptor/
    ├── exception/
    └── specification/


