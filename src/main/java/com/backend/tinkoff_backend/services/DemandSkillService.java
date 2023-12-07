package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.repositories.DemandSkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemandSkillService {

    @Autowired
    DemandSkillRepository demandSkillRepository;

    public void createDemandSkill(DemandSkill demandSkill) {
        demandSkillRepository.save(new DemandSkill(demandSkill.getSkillId(), demandSkill.getDemandId()));
    }

    public DemandSkill getDemandSkillById(long demandSkillId) throws ServiceException {
        Optional<DemandSkill> demandSkillData = demandSkillRepository.findById(demandSkillId);

        if (demandSkillData.isPresent())
            return demandSkillData.get();
        throw new ServiceException("No such demandSkill");
    }
}
