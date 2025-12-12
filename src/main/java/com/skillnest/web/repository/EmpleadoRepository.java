package com.skillnest.web.repository;

import com.skillnest.web.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByEmail(String email);
}
