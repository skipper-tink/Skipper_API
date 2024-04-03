package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
    List<EmployeeSkill> findAllBySkillId(long skillId);
    List<EmployeeSkill> findAllByEmployeeId(long employeeId);
}
