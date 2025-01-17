ALTER TABLE usuario
ADD CONSTRAINT uk_nombre UNIQUE (nombre),
ADD CONSTRAINT uk_correo UNIQUE (correoelectronico);