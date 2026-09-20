-- ===================================================================
-- Script Name : edu.sql
-- Service     : EduManager
-- Environment : Development
-- Database    : MySQL 8
-- Author      : Alejandro Saa
-- Created On  : [2026-079-16]
-- Last Update : [2026-079-16]
-- Description :
--   Script para la base de datos del sistema AlkeWallet.
--
--   Este script incluye:
--     1. Creación de la base de datos.
--     2. Creación de tablas.
--     3. Creación de indices.
--     4. Creación de insert.
-- ===================================================================

-- ===================================
-- CREATE DATABASE
-- ===================================

-- eliminar la base de datos si existe
DROP DATABASE IF EXISTS edu;

-- crear la base de datos
CREATE DATABASE edu
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- ===================================
-- CREATE TABLE
-- ===================================

-- estados de los programas académicos
CREATE TABLE academic_program_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- academic_program -> catalogo de carreras
CREATE TABLE academic_program (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code CHAR(255) NOT NULL UNIQUE, -- Academic program abbreviation
    name CHAR(255) NOT NULL, -- Full name of the academic program
    description CHAR(255) NOT NULL,
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_academic_program_status FOREIGN KEY (status_id) REFERENCES academic_program_status(id)
);

-- usuario -> datos del usuario
CREATE TABLE user_information (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE, -- institutional email
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- estados de la relación usuario <-> programa académico
CREATE TABLE user_academic_program_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- usuario <-> programa_academico
CREATE TABLE user_academic_program (
    user_information_id CHAR(36) NOT NULL,
    academic_program_id CHAR(36) NOT NULL,
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (user_information_id, academic_program_id),
    CONSTRAINT fk_user_academic_program_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_user_academic_program_academic_program FOREIGN KEY (academic_program_id) REFERENCES academic_program(id),
    CONSTRAINT fk_user_academic_program_status FOREIGN KEY (status_id) REFERENCES user_academic_program_status(id)
);

-- estados de las credenciales de acceso
CREATE TABLE access_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- acceso -> credenciales de acceso
-- acceso <-> usuarios
CREATE TABLE access (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL UNIQUE,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- bcrypt
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_access_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_access_status FOREIGN KEY (status_id) REFERENCES access_status(id)
);

-- roles -> roles del sistema
CREATE TABLE role (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code CHAR(255) NOT NULL UNIQUE,
    name CHAR(255) NOT NULL UNIQUE,
    description CHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- roles <-> usuarios
CREATE TABLE user_role (
    user_information_id CHAR(36) NOT NULL,
    role_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (user_information_id, role_id),
    CONSTRAINT fk_user_role_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES role(id)
);

-- estados de los cursos
CREATE TABLE course_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- programa_academico <-> cursos
-- cursos -> catalogo de cursos
CREATE TABLE course (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    academic_program_id CHAR(36) NOT NULL,
    code CHAR(255) NOT NULL UNIQUE,
    name CHAR(255) NOT NULL,
    description CHAR(255) NOT NULL,
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_academic_program FOREIGN KEY (academic_program_id) REFERENCES academic_program(id),
    CONSTRAINT fk_course_status FOREIGN KEY (status_id) REFERENCES course_status(id)
);

-- evaluaciones <-> usuario <-> cursos
CREATE TABLE course_evaluation (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL,
    course_id CHAR(36) NOT NULL,
    evaluation_date DATE NOT NULL,
    grade SMALLINT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_evaluation_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_course_evaluation_course FOREIGN KEY (course_id) REFERENCES course(id)
);

-- estados de las prácticas
CREATE TABLE practice_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- practicas -> catalogo de practicas
CREATE TABLE practice (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    academic_program_id CHAR(36) NOT NULL,
    code CHAR(255) NOT NULL UNIQUE,
    name CHAR(255) NOT NULL,
    description CHAR(255) NOT NULL,
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_practice_academic_program FOREIGN KEY (academic_program_id) REFERENCES academic_program(id),
    CONSTRAINT fk_practice_status FOREIGN KEY (status_id) REFERENCES practice_status(id)
);

-- evaluaciones <-> usuario <-> practicas
CREATE TABLE practice_evaluation (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL,
    practice_id CHAR(36) NOT NULL,
    evaluation_date DATE NOT NULL,
    grade SMALLINT UNSIGNED NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_practice_evaluation_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_practice_evaluation_practice FOREIGN KEY (practice_id) REFERENCES practice(id)
);

-- reglas de evaluación -> desde el 4.0 en adelante se considera aprobado
CREATE TABLE grade_rule (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    grade SMALLINT UNSIGNED NOT NULL UNIQUE,
    approved BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- access_token -> utiliza jwt para cada usuario
CREATE TABLE access_token (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL UNIQUE,
    token VARCHAR(512) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_access_token_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id)
);

-- refresh_token -> utiliza jwt para cada usuario
CREATE TABLE refresh_token (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL UNIQUE,
    token VARCHAR(512) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_refresh_token_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id)
);

-- ===================================
-- CREATE INDEX
-- ===================================

CREATE INDEX idx_academic_program_status_id ON academic_program(status_id);

CREATE INDEX idx_user_academic_program_academic_program_id ON user_academic_program(academic_program_id);

CREATE INDEX idx_user_academic_program_status_id ON user_academic_program(status_id);

CREATE INDEX idx_access_status_id ON access(status_id);

CREATE INDEX idx_user_role_role_id ON user_role(role_id);

CREATE INDEX idx_course_academic_program_id ON course(academic_program_id);

CREATE INDEX idx_course_status_id ON course(status_id);

CREATE INDEX idx_course_evaluation_user_information_id ON course_evaluation(user_information_id);

CREATE INDEX idx_course_evaluation_course_id ON course_evaluation(course_id);

CREATE INDEX idx_practice_academic_program_id ON practice(academic_program_id);

CREATE INDEX idx_practice_status_id ON practice(status_id);

CREATE INDEX idx_practice_evaluation_user_information_id ON practice_evaluation(user_information_id);

CREATE INDEX idx_practice_evaluation_practice_id ON practice_evaluation(practice_id);

-- ===================================
-- INSERT
-- ===================================

INSERT INTO academic_program_status (code, name, description) 
VALUES
    ('ACTIVE', 'Activo', 'Programa académico vigente y disponible para estudiantes'),
    ('SUSPENDED', 'Suspendido', 'Programa académico temporalmente suspendido'),
    ('CLOSING', 'En cierre', 'Programa académico que se encuentra en proceso de cierre'),
    ('CLOSED', 'Cerrado', 'Programa académico que ha finalizado y ya no se encuentra disponible');

INSERT INTO academic_program (code, name, description, status_id) 
VALUES 
    ('ICINF', 'Ingeniería Civil en Informática', 'Programa académico de Ingeniería Civil en Informática', 
        (SELECT id FROM academic_program_status WHERE code = 'ACTIVE')
    );

INSERT INTO user_information (first_name, last_name, email) 
VALUES 
    ('Estudiante', 'Prueba', 'estudiante@edu.cl');

INSERT INTO user_academic_program_status (code, name, description) 
VALUES 
    ('ACTIVE', 'Activo', 'Usuario activo en el programa académico'),
    ('SUSPENDED', 'Suspendido', 'Usuario temporalmente suspendido del programa académico'),
    ('GRADUATED', 'Egresado', 'Usuario que ha completado las actividades académicas del programa'),
    ('WITHDRAWN', 'Retirado', 'Usuario que ha dejado de pertenecer al programa académico');

INSERT INTO user_academic_program (user_information_id, academic_program_id, status_id) 
VALUES 
    (
        (SELECT id FROM user_information WHERE email = 'estudiante@edu.cl'),
        (SELECT id FROM academic_program WHERE code = 'ICINF'),
        (SELECT id FROM user_academic_program_status WHERE code = 'ACTIVE')
    );

INSERT INTO access_status (code, name, description) 
VALUES 
    ('ACTIVE', 'Activo', 'Acceso habilitado para el usuario'),
    ('BLOCKED', 'Bloqueado', 'Acceso bloqueado para el usuario'),
    ('INACTIVE', 'Inactivo', 'Acceso deshabilitado para el usuario');

INSERT INTO access (user_information_id, username, password, status_id) 
VALUES 
    (
        (SELECT id FROM user_information WHERE email = 'estudiante@edu.cl'),
        'estudiante',
        '$2y$10$58xqirCveK1/r2mwmLodw.W7S2bwXYLvUYelmux8QUWMSBWLaFflW',
        (SELECT id FROM access_status WHERE code = 'ACTIVE')
    );

INSERT INTO role (code, name, description) 
VALUES 
    ('STUDENT', 'Estudiante', 'Rol correspondiente a un usuario estudiante');

INSERT INTO user_role (user_information_id, role_id) 
VALUES 
    (
        (SELECT id FROM user_information WHERE email = 'estudiante@edu.cl'),
        (SELECT id FROM role WHERE code = 'STUDENT')
    );

INSERT INTO course_status (code, name, description) 
VALUES 
    ('ACTIVE', 'Activo', 'Curso académico vigente y disponible para ser cursado'),
    ('INACTIVE', 'Inactivo', 'Curso académico que no se encuentra disponible para ser cursado');

INSERT INTO course (academic_program_id, code, name, description, status_id) 
VALUES 
    (
        (SELECT id FROM academic_program WHERE code = 'ICINF'),
        'PROG-001',
        'Programación',
        'Curso de programación',
        (SELECT id FROM course_status WHERE code = 'ACTIVE')
    );

INSERT INTO course_evaluation (user_information_id, course_id, evaluation_date, grade) 
VALUES 
    (
        (SELECT id FROM user_information WHERE email = 'estudiante@edu.cl'),
        (SELECT id FROM course WHERE code = 'PROG-001'),
        '2026-09-17',
        600
    );

INSERT INTO practice_status (code, name, description) 
VALUES 
    ('ACTIVE', 'Activo', 'Práctica académica vigente y disponible para ser realizada'),
    ('INACTIVE', 'Inactivo', 'Práctica académica que no se encuentra disponible para ser realizada');

INSERT INTO practice (academic_program_id, code, name, description, status_id) 
VALUES 
    (
        (SELECT id FROM academic_program WHERE code = 'ICINF'),
        'PRACT-001',
        'Práctica Profesional',
        'Práctica profesional del programa de Ingeniería Civil en Informática',
        (SELECT id FROM practice_status WHERE code = 'ACTIVE')
    );

INSERT INTO practice_evaluation (user_information_id, practice_id, evaluation_date, grade) 
VALUES 
    (
        (SELECT id FROM user_information WHERE email = 'estudiante@edu.cl'),
        (SELECT id FROM practice WHERE code = 'PRACT-001'),
        '2026-09-17',
        600
    );

INSERT INTO grade_rule (grade, approved) 
VALUES 
    (100, FALSE),
    (200, FALSE),
    (300, FALSE),
    (400, TRUE),
    (500, TRUE),
    (600, TRUE),
    (700, TRUE);