package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.services.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeSkillController {

    @Autowired
    EmployeeSkillService employeeSkillService;

    @PostMapping("/employee/{employeeId}/skills")
    public ResponseEntity createSkillsOnEmployee(@PathVariable("employeeId") long employeeId, @RequestBody List<Long> skillIds) {
        employeeSkillService.createSkillsOnEmployee(employeeId, skillIds);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}/skills")
    public ResponseEntity<List<Skill>> getSkillsByEmployeeId(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<>(employeeSkillService.getSkillsByEmployeeId(employeeId), HttpStatus.OK);
    }

    @PutMapping("/employee/{employeeId}/skills")
    public ResponseEntity updateSkillsOnEmployee(@PathVariable("employeeId") long employeeId, @RequestBody List<Long> skillIds) {
        employeeSkillService.updateSkillsOnEmployee(employeeId, skillIds);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}/skills")
    public ResponseEntity deleteSkillsByEmployeeId(@PathVariable("employeeId") long employeeId) {
        employeeSkillService.deleteSkillsByEmployeeId(employeeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employeeSkills")
    public ResponseEntity deleteAllEmployeeSkills() {
        employeeSkillService.deleteAllEmployeeSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
