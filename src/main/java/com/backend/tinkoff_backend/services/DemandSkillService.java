package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.repositories.DemandSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandSkillService {

    @Autowired
    DemandSkillRepository demandSkillRepository;

    public void createDemandSkill(DemandSkill demandSkill) {
        demandSkillRepository.save(new DemandSkill(demandSkill.getSkillId(), demandSkill.getDemandId()));
    }
}
