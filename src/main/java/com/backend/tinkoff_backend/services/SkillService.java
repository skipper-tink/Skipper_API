package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public void createSkill(Skill skill) {
        skillRepository.save(new Skill(skill.getSkillName()));
    }
}
