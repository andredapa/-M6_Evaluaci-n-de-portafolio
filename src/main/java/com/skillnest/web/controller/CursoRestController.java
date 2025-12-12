package com.skillnest.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillnest.web.model.Curso;
import com.skillnest.web.model.Empleado;
import com.skillnest.web.model.Inscripcion;
import com.skillnest.web.repository.CursoRepository;
import com.skillnest.web.repository.EmpleadoRepository;
import com.skillnest.web.repository.InscripcionRepository;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    private final CursoRepository cursoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final InscripcionRepository inscripcionRepository;

    public CursoRestController(CursoRepository cursoRepository, EmpleadoRepository empleadoRepository,
                               InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.empleadoRepository = empleadoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping("/inscripciones")
    public Inscripcion registrar(@RequestParam Long cursoId, @RequestParam Long empleadoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow();
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCurso(curso);
        inscripcion.setEmpleado(empleado);
        return inscripcionRepository.save(inscripcion);
    }
}