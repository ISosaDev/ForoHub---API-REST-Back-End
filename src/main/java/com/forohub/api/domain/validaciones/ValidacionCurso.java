package com.forohub.api.domain.validaciones;

import com.forohub.api.domain.ValidacionException;
import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.curso.DatosCursos;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCurso implements Validador<DatosCursos> {

    private final CursoRepository cursoRepository;

    public ValidacionCurso(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


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
        if (cursoRepository.existsByNombre(datosCursos.nombre())){
            throw new ValidacionException("Ya existe un curso con el mismo nombre");
        }
    }
}
