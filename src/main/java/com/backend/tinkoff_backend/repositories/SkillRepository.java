package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
