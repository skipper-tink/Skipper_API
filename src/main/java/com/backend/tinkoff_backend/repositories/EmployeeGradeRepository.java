package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.EmployeeGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeGradeRepository extends JpaRepository<EmployeeGrade, Long> {
}
