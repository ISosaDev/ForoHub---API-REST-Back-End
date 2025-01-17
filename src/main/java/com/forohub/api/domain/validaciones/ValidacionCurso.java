package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.DatosCursos;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCurso implements Validador<DatosCursos> {

    @Override
    public void validar(DatosCursos datosCursos) {
        if (datosCursos == null) {
            throw new IllegalArgumentException("Los datos del curso no pueden ser nulos.");
        }
        if (datosCursos.nombre() == null || datosCursos.nombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }
        if (datosCursos.categoria() == null || datosCursos.categoria().isBlank()) {
            throw new IllegalArgumentException("La categoría del curso no puede estar vacía.");
        }
    }
}
