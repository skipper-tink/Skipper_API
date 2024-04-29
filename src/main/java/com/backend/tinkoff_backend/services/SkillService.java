package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.jpaRepositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public Optional<Long> createSkill(Skill skill) {
        return Optional.of(new Skill(skill))
                .map(s -> skillRepository.save(s).getId());
    }

    public Optional<Skill> getSkillById(long skillId) {
        return skillRepository.findById(skillId);
    }

    public List<Skill> getAllSkillsBySpecialization(String specialization) {
        return skillRepository.findAllBySpecialization(specialization);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> updateSkill(long skillId, Skill skill) {
        return skillRepository.findById(skillId)
                .map(s -> mergeSkill(s, skill))
                .map(s -> skillRepository.save(s));
    }

    public Optional<Skill> deleteSkill(long skillId) {
        return skillRepository.findById(skillId).stream()
                .peek(s -> skillRepository.deleteById(skillId))
                .findAny();
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
