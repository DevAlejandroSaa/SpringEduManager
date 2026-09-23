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

-- Almacena los datos personales y de contacto de los usuarios.
CREATE TABLE user_information (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE, -- email institucional
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Almacena los roles disponibles para los usuarios del sistema.
CREATE TABLE role (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Define los estados en los que puede encontrarse el acceso de un usuario.
CREATE TABLE access_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Almacena las credenciales de acceso y relaciona al usuario con su rol.
CREATE TABLE access (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    role_id CHAR(36) NOT NULL,
    user_information_id CHAR(36) NOT NULL UNIQUE,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- bcrypt
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_access_role FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT fk_access_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT fk_access_status FOREIGN KEY (status_id) REFERENCES access_status(id)
);

-- Almacena el token de acceso asociado a un usuario.
CREATE TABLE access_token (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL,
    token VARCHAR(512) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_access_token_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT chk_access_token_expiration CHECK (expires_at > created_at)
);

-- Almacena el token de actualización asociado a un usuario.
CREATE TABLE refresh_token (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_information_id CHAR(36) NOT NULL,
    token VARCHAR(512) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_refresh_token_user_information FOREIGN KEY (user_information_id) REFERENCES user_information(id),
    CONSTRAINT chk_refresh_token_expiration CHECK (expires_at > created_at)
);

-- Conserva las reglas de negocio utilizadas para determinar si una calificación es aprobada.
CREATE TABLE grade_rule (
    iid CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    grade SMALLINT UNSIGNED NOT NULL UNIQUE, -- 100 al 700
    approved BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT chk_grade_rule_grade CHECK (grade BETWEEN 1 AND 7)
);

-- Define los estados disponibles para las carreras o programas académicos.
CREATE TABLE academic_program_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Almacena el catálogo de carreras o programas académicos.
CREATE TABLE academic_program (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL UNIQUE,
    description VARCHAR(255),
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_academic_program_status FOREIGN KEY (status_id) REFERENCES academic_program_status(id)
);

-- Define los estados disponibles para los cursos.
CREATE TABLE course_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Almacena el catálogo permanente de cursos asociados a las carreras.
CREATE TABLE course (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    academic_program_id CHAR(36) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL UNIQUE,
    description VARCHAR(255),
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_academic_program FOREIGN KEY (academic_program_id) REFERENCES academic_program(id),
    CONSTRAINT fk_course_status FOREIGN KEY (status_id) REFERENCES course_status(id)
);

-- Representa una instancia concreta de un curso disponible para ser inscrita.
CREATE TABLE course_offering (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    course_id CHAR(36) NOT NULL,
    teacher_user_id CHAR(36) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_offering_course FOREIGN KEY (course_id) REFERENCES course(id),
    CONSTRAINT fk_course_offering_teacher FOREIGN KEY (teacher_user_id) REFERENCES user_information(id),
    CONSTRAINT chk_course_offering_dates CHECK (end_date >= start_date)
);

-- Registra la inscripción de un estudiante en una instancia concreta de un curso.
CREATE TABLE user_course (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    student_user_id CHAR(36) NOT NULL,
    course_offering_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_course_student FOREIGN KEY (student_user_id) REFERENCES user_information(id),
    CONSTRAINT fk_user_course_offering FOREIGN KEY (course_offering_id) REFERENCES course_offering(id),
    CONSTRAINT uq_user_course_student_offering UNIQUE (student_user_id, course_offering_id)
);

-- Registra las evaluaciones de los cursos realizadas a los estudiantes.
CREATE TABLE course_evaluation (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_course_id CHAR(36) NOT NULL,
    grade SMALLINT UNSIGNED NOT NULL, -- 100 al 700
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_evaluation_user_course FOREIGN KEY (user_course_id) REFERENCES user_course(id)
);

-- Registra las clases de una instancia de curso, incluyendo fecha, horario y sala virtual.
CREATE TABLE course_class (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    course_offering_id CHAR(36) NOT NULL,
    class_date VARCHAR(20) NOT NULL,  -- dia de la semana
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    virtual_url VARCHAR(512) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_course_class_offering FOREIGN KEY (course_offering_id) REFERENCES course_offering(id),
    CONSTRAINT uq_course_class_schedule UNIQUE (course_offering_id, class_date, start_time, end_time),
    CONSTRAINT chk_course_class_date CHECK (class_date IN ('lunes', 'martes', 'miércoles', 'jueves', 'viernes', 'sábado', 'domingo')),
    CONSTRAINT chk_course_class_time CHECK (end_time > start_time)
);

-- Define los estados disponibles para las prácticas.
CREATE TABLE practice_status (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Almacena el catálogo de prácticas asociadas a las carreras.
CREATE TABLE practice (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    academic_program_id CHAR(36) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL UNIQUE,
    description VARCHAR(255),
    status_id CHAR(36) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_practice_academic_program FOREIGN KEY (academic_program_id) REFERENCES academic_program(id),
    CONSTRAINT fk_practice_status FOREIGN KEY (status_id) REFERENCES practice_status(id)
);

-- Registra las prácticas realizadas por los estudiantes y los datos de sus responsables.
CREATE TABLE user_practice (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    student_user_id CHAR(36) NOT NULL,
    practice_id CHAR(36) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    practice_location VARCHAR(255) NOT NULL,
    responsible_name VARCHAR(200) NOT NULL,
    responsible_email VARCHAR(255) NOT NULL,
    responsible_phone VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_practice_student FOREIGN KEY (student_user_id) REFERENCES user_information(id),
    CONSTRAINT fk_user_practice_practice FOREIGN KEY (practice_id) REFERENCES practice(id),
    CONSTRAINT chk_user_practice_dates CHECK (end_date >= start_date)
);

-- Registra las evaluaciones de las prácticas realizadas por los estudiantes.
CREATE TABLE practice_evaluation (
    id CHAR(36) NOT NULL DEFAULT (UUID()) PRIMARY KEY,
    user_practice_id CHAR(36) NOT NULL,
    grade SMALLINT UNSIGNED NOT NULL, -- 100 al 700
    description VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_practice_evaluation_user_practice FOREIGN KEY (user_practice_id) REFERENCES user_practice(id)
);

-- ===================================
-- CREATE INDEX
-- ===================================

-- Permite obtener rápidamente todos los estudiantes inscritos en una oferta.
CREATE INDEX idx_user_course_course_offering_id ON user_course (course_offering_id);

-- Permite obtener rápidamente las ofertas impartidas por un docente.
CREATE INDEX idx_course_offering_teacher_user_id ON course_offering (teacher_user_id);

-- ===================================
-- INSERT
-- ===================================

INSERT INTO user_information (first_name, last_name, email) 
VALUES 
    ('Alejandro', 'Saa Silva', 'alejandro.saa@edu.cl'),
    ('Carlos', 'González', 'carlos.gonzalez@edu.cl');

INSERT INTO role (code, name, description) 
VALUES
    ('ADMIN', 'Administrador', 'Usuario con permisos administrativos del sistema.'),
    ('ESTUDIANTE', 'Estudiante', 'Usuario perteneciente al perfil de estudiante.'),
    ('DOCENTE', 'Docente', 'Usuario responsable de impartir cursos académicos.');

INSERT INTO access_status (code, name, description) 
VALUES
    ('ACTIVE', 'Activo', 'El usuario puede acceder al sistema.',),
    ('INACTIVE', 'Inactivo', 'El usuario no puede acceder al sistema.'),
    ('BLOCKED', 'Bloqueado', 'El acceso del usuario se encuentra bloqueado.');

INSERT INTO access (role_id, user_information_id, username, password, status_id)
SELECT
    r.id, 
    ui.id, 
    'alejandro.saa', 
    '$2y$10$58xqirCveK1/r2mwmLodw.W7S2bwXYLvUYelmux8QUWMSBWLaFflW', 
    s.id
FROM user_information ui
CROSS JOIN role r
CROSS JOIN access_status s
WHERE ui.email = 'alejandro.saa@edu.cl' 
    AND r.code = 'ESTUDIANTE' 
    AND s.code = 'ACTIVE';

INSERT INTO grade_rule (grade, approved) 
VALUES
    (100, FALSE),
    (200, FALSE),
    (300, FALSE),
    (400, TRUE),
    (500, TRUE),
    (600, TRUE),
    (700, TRUE);

INSERT INTO academic_program_status (code, name, description) 
VALUES
    ('ACTIVE', 'Activo', 'La carrera o programa académico se encuentra disponible.'),
    ('INACTIVE', 'Inactivo', 'La carrera o programa académico no se encuentra disponible.'),
    ('DISCONTINUED', 'Descontinuado', 'La carrera o programa académico dejó de impartirse.');

INSERT INTO academic_program (code, name, description, status_id)
SELECT
    'ICI',
    'Ingeniería Civil en Informática',
    'Programa académico de Ingeniería Civil en Informática.',
    aps.id
FROM academic_program_status aps
WHERE aps.code = 'ACTIVE';

INSERT INTO course_status (code, name, description) 
VALUES
    ('ACTIVE', 'Activo', 'El curso se encuentra disponible para ser utilizado.'),
    ('INACTIVE', 'Inactivo', 'El curso no se encuentra disponible para ser utilizado.'),
    ('DISCONTINUED', 'Descontinuado', 'El curso dejó de formar parte del catálogo académico.');

INSERT INTO course (academic_program_id, code, name, description, status_id)
SELECT
    ap.id,
    c.code,
    c.name,
    c.description,
    cs.id
FROM academic_program ap
CROSS JOIN course_status cs
CROSS JOIN (
    SELECT
        'INF101' AS code,
        'Programación I' AS name,
        'Curso de fundamentos de programación.' AS description
    UNION ALL
    SELECT
        'INF102',
        'Bases de Datos',
        'Curso de fundamentos de bases de datos.'
    UNION ALL
    SELECT
        'INF103',
        'Desarrollo de Software',
        'Curso de fundamentos del desarrollo de software.'
) c
WHERE ap.code = 'ICI'
    AND cs.code = 'ACTIVE';

INSERT INTO course_offering (course_id, teacher_user_id, start_date, end_date)
SELECT
    c.id,
    ui.id,
    '2026-03-02',
    '2026-07-10'
FROM course c
CROSS JOIN user_information ui
WHERE c.code = 'INF101'
    AND ui.email = 'carlos.gonzalez@edu.cl';

INSERT INTO course_offering (course_id, teacher_user_id, start_date, end_date)
SELECT
    c.id,
    ui.id,
    '2026-03-02',
    '2026-07-10'
FROM course c
CROSS JOIN user_information ui
WHERE c.code = 'INF102'
    AND ui.email = 'carlos.gonzalez@edu.cl';

INSERT INTO course_offering (course_id, teacher_user_id, start_date, end_date)
SELECT
    c.id,
    ui.id,
    '2026-03-02',
    '2026-07-10'
FROM course c
CROSS JOIN user_information ui
WHERE c.code = 'INF103'
    AND ui.email = 'carlos.gonzalez@edu.cl';

INSERT INTO user_course (student_user_id, course_offering_id)
SELECT
    ui.id,
    co.id
FROM user_information ui
CROSS JOIN course_offering co
JOIN course c ON c.id = co.course_id
WHERE ui.email = 'alejandro.saa@edu.cl'
    AND c.code IN ('INF101', 'INF102', 'INF103');

INSERT INTO course_evaluation (user_course_id, grade)
SELECT
    uc.id,
    e.grade
FROM user_course uc
JOIN course_offering co ON co.id = uc.course_offering_id
JOIN course c ON c.id = co.course_id
JOIN (
    SELECT 'INF101' AS code, 550 AS grade
    UNION ALL
    SELECT 'INF102', 620
    UNION ALL
    SELECT 'INF103', 480
) e ON e.code = c.code
JOIN user_information ui ON ui.id = uc.student_user_id
WHERE ui.email = 'alejandro.saa@edu.cl';

INSERT INTO course_class (course_offering_id, class_date, start_time, end_time, virtual_url)
SELECT
    co.id,
    'lunes',
    '18:00:00',
    '20:00:00',
    'https://edu.cl/aulas/inf101'
FROM course_offering co
JOIN course c ON c.id = co.course_id
WHERE c.code = 'INF101';

INSERT INTO course_class (course_offering_id, class_date, start_time, end_time, virtual_url)
SELECT
    co.id,
    'martes',
    '18:00:00',
    '20:00:00',
    'https://edu.cl/aulas/inf102'
FROM course_offering co
JOIN course c ON c.id = co.course_id
WHERE c.code = 'INF102';

INSERT INTO course_class (course_offering_id, class_date, start_time, end_time, virtual_url)
SELECT
    co.id,
    'miércoles',
    '18:00:00',
    '20:00:00',
    'https://edu.cl/aulas/inf103'
FROM course_offering co
JOIN course c ON c.id = co.course_id
WHERE c.code = 'INF103';

INSERT INTO practice_status (code, name, description) 
VALUES
    ('ACTIVE', 'Activo', 'La práctica se encuentra disponible para ser realizada.'),
    ('INACTIVE', 'Inactivo', 'La práctica no se encuentra disponible para ser realizada.'),
    ('DISCONTINUED', 'Descontinuado', 'La práctica dejó de formar parte del catálogo académico.');

INSERT INTO practice (academic_program_id, code, name, description, status_id)
SELECT
    ap.id,
    p.code,
    p.name,
    p.description,
    ps.id
FROM academic_program ap
CROSS JOIN practice_status ps
CROSS JOIN (
    SELECT
        'PRACTICA1' AS code,
        'Práctica Profesional I' AS name,
        'Primera práctica profesional del programa académico.' AS description
    UNION ALL
    SELECT
        'PRACTICA2',
        'Práctica Profesional II',
        'Segunda práctica profesional del programa académico.'
) p
WHERE ap.code = 'ICI'
    AND ps.code = 'ACTIVE';

INSERT INTO user_practice (
    student_user_id,
    practice_id,
    start_date,
    end_date,
    practice_location,
    responsible_name,
    responsible_email,
    responsible_phone
)
SELECT
    ui.id,
    p.id,
    '2026-03-02',
    '2026-05-29',
    'Temuco, Chile',
    'María González',
    'maria.gonzalez@empresa.cl',
    '+56 9 8765 4321'
FROM user_information ui
CROSS JOIN practice p
WHERE ui.email = 'alejandro.saa@edu.cl'
    AND p.code = 'PRACTICA1';

INSERT INTO practice_evaluation (user_practice_id, grade, description)
SELECT
    up.id,
    620,
    'Evaluación satisfactoria de la práctica profesional.'
FROM user_practice up
JOIN practice p ON p.id = up.practice_id
JOIN user_information ui ON ui.id = up.student_user_id
WHERE ui.email = 'alejandro.saa@edu.cl'
    AND p.code = 'PRACTICA1';