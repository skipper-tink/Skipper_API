package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
