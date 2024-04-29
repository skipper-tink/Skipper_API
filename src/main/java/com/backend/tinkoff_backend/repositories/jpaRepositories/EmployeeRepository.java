package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllBySpecializationAndQualification(String specialization, String qualification);
}
