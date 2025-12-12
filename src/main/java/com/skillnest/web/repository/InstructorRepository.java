package com.skillnest.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillnest.web.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}