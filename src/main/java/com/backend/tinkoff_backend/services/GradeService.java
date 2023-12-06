package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Grade;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.GradeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ServerCloneException;
import java.util.List;
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

    public List<Grade> getGradesByEmployeeId(long employeeId) throws ServiceException {
        List<Grade> grades = gradeRepository.findAllByEmployeeId(employeeId);

        if (grades.isEmpty())
            throw new ServiceException("This employee hasn't grades");
        return grades;
    }

    public List<Grade> getAllGrades() throws ServiceException {
        List<Grade> grades = gradeRepository.findAll();

        if (grades.isEmpty())
            throw new ServiceException("No grades");
        return grades;
    }

    public Grade updateGrade(long gradeId, Grade grade) throws ServiceException {
        Optional<Grade> gradeData = gradeRepository.findById(gradeId);

        if (gradeData.isPresent()) {
            Grade _grade = gradeData.get();
            _grade.setGradeQualification(grade.getGradeQualification());
            _grade.setGradeSpecialization(grade.getGradeSpecialization());
            _grade.setEmployeeId(grade.getEmployeeId());
            return gradeRepository.save(_grade);
        }
        throw new ServiceException("No such grade");
    }
}
