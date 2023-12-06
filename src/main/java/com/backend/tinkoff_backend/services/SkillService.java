package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.SkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public void createSkill(Skill skill) {
        skillRepository.save(new Skill(skill.getSkillName()));
    }

    public Skill getSkillById(long skillId) throws ServiceException {
        Optional<Skill> skillData = skillRepository.findById(skillId);

        if (skillData.isPresent())
            return skillData.get();
        throw new ServiceException("No such skill");
    }

    public List<Skill> getAllSkills() throws ServiceException {
        List<Skill> skills = skillRepository.findAll();

        if (skills.isEmpty())
            throw new ServiceException("No skills");
        return skills;
    }
}
