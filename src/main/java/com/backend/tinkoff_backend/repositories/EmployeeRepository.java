package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUserLogin(String userLogin);
}
