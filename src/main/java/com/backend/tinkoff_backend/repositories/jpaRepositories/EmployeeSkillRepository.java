package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
    Optional<EmployeeSkill> findByEmployeeIdAndSkillId(long employeeId, long skillId);
}
