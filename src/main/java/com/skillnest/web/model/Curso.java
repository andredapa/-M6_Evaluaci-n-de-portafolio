package com.skillnest.web.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne
    private Instructor instructor;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscripciones;

    // Getters y Setters
}
