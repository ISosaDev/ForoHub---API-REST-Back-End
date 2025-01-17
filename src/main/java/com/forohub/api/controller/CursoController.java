package com.forohub.api.controller;


import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.curso.CursoService;
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
    private CursoService servicioCurso;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody DatosCursos datosCursos) {
        // Crear el curso utilizando el servicio
        Curso cursoGuardado = servicioCurso.crearCurso(datosCursos);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoGuardado);
    }
}
