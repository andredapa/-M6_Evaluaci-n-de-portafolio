package com.skillnest.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillnest.web.model.Curso;
import com.skillnest.web.repository.CursoRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CursoRepository cursoRepository;

    public AdminController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/cursos")
    public String listarCursos(Model model){
        model.addAttribute("cursos", cursoRepository.findAll());
        return "admin/cursos";
    }

    @PostMapping("/cursos")
    public String crearCurso(@ModelAttribute Curso curso){
        cursoRepository.save(curso);
        return "redirect:/admin/cursos";
    }
}