package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.DemandSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandSkillRepository extends JpaRepository<DemandSkill, Long> {
    List<DemandSkill> findAllByDemandId(long demandId);
    List<DemandSkill> findAllBySkillId(long skillId);
}
