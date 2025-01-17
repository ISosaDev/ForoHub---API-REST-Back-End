package com.forohub.api.domain.curso;


import com.forohub.api.domain.validaciones.ValidacionCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private ValidacionCurso validacionCurso;

    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(DatosCursos datosCursos) {
        validacionCurso.validar(datosCursos);
        Curso curso = new Curso(datosCursos);
        return cursoRepository.save(curso);
    }
}
