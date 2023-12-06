package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Grade;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.GradeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public void createGrade(Grade grade) {
        gradeRepository.save(new Grade(grade.getEmployeeId(),
                grade.getGradeSpecialization(), grade.getGradeQualification()));
    }

    public Grade getGradeById(long gradeId) throws ServiceException {
        Optional<Grade> gradeData = gradeRepository.findById(gradeId);

        if (gradeData.isPresent())
            return gradeData.get();
        throw new ServiceException("No such grade");
    }
}
