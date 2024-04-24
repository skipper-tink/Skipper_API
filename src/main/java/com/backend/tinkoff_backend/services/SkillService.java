package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public Optional<Long> createSkill(Skill skill) {
        Optional<Skill> opt = skillRepository.findByNameAndSpecialization(skill.getName(), skill.getSpecialization());
        return Optional.empty()
                .map(value -> opt.isEmpty()
                        ? skillRepository.save(new Skill(skill.getName(), skill.getSpecialization())).getId()
                        : null
                );
    }

    public Optional<Skill> getSkillById(long skillId) {
        return skillRepository.findById(skillId);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> updateSkill(long skillId, Skill skill) {
        Optional<Skill> skillData = skillRepository.findById(skillId);

        return skillData
                .map(s -> skillRepository.findByNameAndSpecialization(skill.getName(), skill.getSpecialization()).isEmpty()
                        ? mergeSkill(s, skill)
                        : null).map(s -> skillRepository.save(s));
    }

    public Optional<Skill> deleteSkill(long skillId) {
        Optional<Skill> skillData = skillRepository.findById(skillId);

        return skillData
                .map(s -> {
                    skillRepository.deleteById(skillId);
                    return s;
                });
    }

    public void deleteAllSkills() {
        skillRepository.deleteAll();
    }

    private Skill mergeSkill(Skill s, Skill skill) {
        s.setName(skill.getName());
        s.setSpecialization(skill.getSpecialization());
        return s;
    }
}
