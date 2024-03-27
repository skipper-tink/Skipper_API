package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.GradeSkill;
import com.backend.tinkoff_backend.repositories.GradeSkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeSkillService {

    @Autowired
    GradeSkillRepository gradeSkillRepository;

    public void createGradeSkill(GradeSkill gradeSkill) {
        gradeSkillRepository.save(new GradeSkill(gradeSkill.getSkillId(), gradeSkill.getGradeId()));
    }

    public GradeSkill getGradeSkillById(long gradeSkillId) throws ServiceException {
        Optional<GradeSkill> gradeSkillData = gradeSkillRepository.findById(gradeSkillId);

        if (gradeSkillData.isPresent())
            return gradeSkillData.get();
        throw new ServiceException("No such gradeSkill");
    }

    public List<GradeSkill> getGradeSkillsByGradeId(long gradeId) throws ServiceException {
        List<GradeSkill> gradeSkills = gradeSkillRepository.findAllByGradeId(gradeId);

        if (gradeSkills.isEmpty())
            throw new ServiceException("This grade not have any skills");
        return gradeSkills;
    }

    public List<GradeSkill> getGradeSkillsBySkillId(long skillId) throws ServiceException {
        List<GradeSkill> gradeSkills = gradeSkillRepository.findAllBySkillId(skillId);

        if (gradeSkills.isEmpty())
            throw new ServiceException("This skill not involved in any grades");
        return gradeSkills;
    }

    public List<GradeSkill> getAllGradeSKills() throws ServiceException {
        List<GradeSkill> gradeSkills = gradeSkillRepository.findAll();

        if (gradeSkills.isEmpty())
            throw new ServiceException("No gradeSkills");
        return gradeSkills;
    }

    public GradeSkill updateGradeSkill(long gradeSkillId, GradeSkill gradeSkill) throws ServiceException {
        Optional<GradeSkill> gradeSkillData = gradeSkillRepository.findById(gradeSkillId);

        if (gradeSkillData.isPresent()) {
            GradeSkill _gradeSkill = gradeSkillData.get();
            _gradeSkill.setGradeId(gradeSkill.getGradeId());
            _gradeSkill.setSkillId(gradeSkill.getSkillId());
            return gradeSkillRepository.save(_gradeSkill);
        }
        throw new ServiceException("No such gradeSkill");
    }

    public void deleteGradeSKill(long gradeSkillId) throws ServiceException {
        Optional<GradeSkill> gradeSkillData = gradeSkillRepository.findById(gradeSkillId);

        if (gradeSkillData.isPresent()) {
            gradeSkillRepository.deleteById(gradeSkillId);
            return;
        }
        throw new ServiceException("No such gradeSkill");
    }

    public void deleteAllGradeSkills() {
        gradeSkillRepository.deleteAll();
    }
}
