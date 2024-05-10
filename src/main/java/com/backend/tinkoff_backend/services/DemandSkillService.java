package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcDemandRepository;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcSkillRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.DemandSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandSkillService {

    @Autowired
    DemandSkillRepository demandSkillRepository;
    @Autowired
    JdbcSkillRepository jdbcSkillRepository;
    @Autowired
    JdbcDemandRepository jdbcDemandRepository;

    public void createSkillsOnDemand(long demandId, List<Long> skillIds) {
        demandSkillRepository.saveAll(skillIds.stream().map(id -> new DemandSkill(id, demandId)).toList());
    }

    public List<Skill> getSkillsByDemandId(long demandId) {
        return jdbcSkillRepository.getSkillsByDemandId(demandId);
    }

    public void updateSkillsOnDemand(long demandId, List<Long> skillIds) {
        demandSkillRepository.deleteAll();
        demandSkillRepository.saveAll(skillIds.stream().map(id -> new DemandSkill(id, demandId)).toList());
    }

    public void deleteSkillsOnDemand(long demandId) {
        jdbcDemandRepository.deleteSkillsOnDemand(demandId);
    }

    public void deleteAllDemandSkills() {
        demandSkillRepository.deleteAll();
    }
}
