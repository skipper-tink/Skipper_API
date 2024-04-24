package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByNameAndSpecialization(String name, String specialization);

    List<Skill> findAllBySpecialization(String specialization);
}
