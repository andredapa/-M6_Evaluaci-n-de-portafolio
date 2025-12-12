package com.skillnest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillnest.web.repository.CursoRepository;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    private final CursoRepository cursoRepository;

    public EmpleadoController(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/cursos")
    public String listarCursos(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());
        return "empleado/cursos";
    }
}