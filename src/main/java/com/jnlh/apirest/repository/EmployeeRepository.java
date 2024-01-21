package com.jnlh.apirest.repository;

import com.jnlh.apirest.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Empleado, Long> {
}
