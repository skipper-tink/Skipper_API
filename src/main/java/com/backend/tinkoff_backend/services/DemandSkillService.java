package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.repositories.DemandSkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<DemandSkill> getDemandSkillsByDemandId(long demandId) throws ServiceException {
        List<DemandSkill> demandSkills = demandSkillRepository.findAllByDemandId(demandId);

        if (demandSkills.isEmpty())
            throw new ServiceException("Do not need any skills in that demand");
        return demandSkills;
    }

    public List<DemandSkill> getDemandSkillsBySkillId(long skillId) throws ServiceException {
        List<DemandSkill> demandSkills = demandSkillRepository.findAllBySkillId(skillId);

        if (demandSkills.isEmpty())
            throw new ServiceException("This skill not involved in any demand");
        return demandSkills;
    }
}
