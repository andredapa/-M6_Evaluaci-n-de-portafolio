package com.skillnest.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillnest.web.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}