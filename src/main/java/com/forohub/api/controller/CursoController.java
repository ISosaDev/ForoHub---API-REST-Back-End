package com.forohub.api.controller;


import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.curso.DatosCursos;
import com.forohub.api.domain.validaciones.ValidacionCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody DatosCursos datosCursos) {
        // Validar datos del curso
        ValidacionCurso.validar(datosCursos);

        // Crear la entidad Curso a partir del DTO
        Curso curso = new Curso(datosCursos);

        // Guardar la entidad en la base de datos
        Curso cursoGuardado = cursoRepository.save(curso);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoGuardado);
    }

}
