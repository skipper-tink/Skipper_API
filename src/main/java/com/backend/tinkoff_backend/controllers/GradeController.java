package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Grade;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.services.GradeService;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping("/grades")
    public ResponseEntity<Grade> createGrade(@RequestParam Grade grade) {
        gradeService.createGrade(grade);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/grades/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable("id") long gradeId) {
        try {
            return new ResponseEntity<>(gradeService.getGradeById(gradeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/grades/{employeeId}")
    public ResponseEntity<List<Grade>> getGradesByEmployeeId(@PathVariable("employeeId") long employeeId) {
        try {
            return new ResponseEntity<>(gradeService.getGradesByEmployeeId(employeeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
