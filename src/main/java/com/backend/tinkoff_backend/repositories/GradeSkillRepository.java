package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.GradeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeSkillRepository extends JpaRepository<GradeSkill, Long> {
    List<GradeSkill> findAllBySkillId(long skillId);
    List<GradeSkill> findAllByGradeId(long gradeId);
}
