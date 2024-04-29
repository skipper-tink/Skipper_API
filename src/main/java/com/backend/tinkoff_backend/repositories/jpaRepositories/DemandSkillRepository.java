package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.DemandSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DemandSkillRepository extends JpaRepository<DemandSkill, Long> {

    Optional<DemandSkill> findByDemandIdAndSkillId(long demandId, long skillId);
    List<DemandSkill> findAllByDemandId(long demandId);
    List<DemandSkill> findAllBySkillId(long skillId);
}
