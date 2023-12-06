package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Grade;
import com.backend.tinkoff_backend.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public void createGrade(Grade grade) {
        gradeRepository.save(new Grade(grade.getEmployeeId(),
                grade.getGradeSpecialization(), grade.getGradeQualification()));
    }
}
