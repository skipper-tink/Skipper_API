package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.repositories.DemandSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandSkillService {

    @Autowired
    DemandSkillRepository demandSkillRepository;

    public Optional<Long> createDemandSkill(DemandSkill demandSkill) {
        if (!isAlreadyExist(demandSkill)) {
            return Optional.of(demandSkillRepository
                    .save(new DemandSkill(demandSkill.getSkillId(), demandSkill.getDemandId()))
                    .getId());
        }
        return Optional.empty();
    }

    public Optional<DemandSkill> getDemandSkillById(long demandSkillId) {
        return demandSkillRepository.findById(demandSkillId);
    }

    public List<DemandSkill> getDemandSkillsByDemandId(long demandId) {
        return demandSkillRepository.findAllByDemandId(demandId);
    }

    public List<DemandSkill> getDemandSkillsBySkillId(long skillId) {
        return demandSkillRepository.findAllBySkillId(skillId);
    }

    public List<DemandSkill> getAllDemandSKills() {
        return demandSkillRepository.findAll();
    }

    public Optional<DemandSkill> updateDemandSkill(long demandSkillId, DemandSkill demandSkill) {
        Optional<DemandSkill> opt = demandSkillRepository.findById(demandSkillId);

        return opt
                .map(ds -> mergeDemandSkill(ds, demandSkill))
                .map(ds -> demandSkillRepository.save(ds));
    }

    public Optional<DemandSkill> deleteDemandSKill(long demandSkillId) {
        Optional<DemandSkill> opt = demandSkillRepository.findById(demandSkillId);

        return opt
                .map(ds -> {
                    demandSkillRepository.deleteById(demandSkillId);
                    return ds;
                });
    }

    public void deleteAllDemandSkills() {
        demandSkillRepository.deleteAll();
    }

    private DemandSkill mergeDemandSkill(DemandSkill ds, DemandSkill demandSkill) {
        ds.setDemandId(demandSkill.getDemandId());
        ds.setSkillId(demandSkill.getSkillId());
        return ds;
    }

    private boolean isAlreadyExist(DemandSkill demandSkill) {
        return demandSkillRepository.findByDemandIdAndSkillId(demandSkill.getDemandId(), demandSkill.getSkillId()).isPresent();
    }
}
