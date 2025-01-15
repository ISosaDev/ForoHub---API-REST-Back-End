CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correoElectronico VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE Curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status ENUM('ABIERTO', 'CERRADO') NOT NULL,
    autor_id BIGINT,
    curso_id BIGINT,
    FOREIGN KEY (autor_id) REFERENCES Usuario(id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id BIGINT,
    fechaCreacion DATETIME NOT NULL,
    autor_id BIGINT,
    solucion VARCHAR(255),
    FOREIGN KEY (topico_id) REFERENCES Topico(id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);