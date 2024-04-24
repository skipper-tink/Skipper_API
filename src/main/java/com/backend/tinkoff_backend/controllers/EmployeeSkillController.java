package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeSkillController {

    @Autowired
    EmployeeSkillService employeeSkillService;

    @PostMapping("/employeeSkills")
    public ResponseEntity<Long> createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        Optional<Long> opt = employeeSkillService.createEmployeeSkill(employeeSkill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        } throw new MyInvalidArgumentException("EmployeeSkill creation error");
    }

    @GetMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> getEmployeeSkillById(@PathVariable("id") long employeeSkillId) {
        Optional<EmployeeSkill> opt = employeeSkillService.getEmployeeSkillById(employeeSkillId);

        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("EmployeeSkill getting by id error");
    }

    @GetMapping("/employeeSkills")
    public ResponseEntity<List<EmployeeSkill>> getAllEmployeeSkills() {
        return new ResponseEntity<>(employeeSkillService.getAllEmployeeSKills(), HttpStatus.OK);
    }

    @PutMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> updateEmployeeSkill(@PathVariable("id") long employeeSkillId,
                                                             @RequestBody EmployeeSkill employeeSkill) {
        Optional<EmployeeSkill> opt = employeeSkillService.updateEmployeeSkill(employeeSkillId, employeeSkill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }  throw new MyRetrievalFailureException("EmployeeSkill updating error");
    }

    @DeleteMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> deleteEmployeeSKill(@PathVariable("id") long employeeSkillId) {
        Optional<EmployeeSkill> opt = employeeSkillService.deleteEmployeeSKill(employeeSkillId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("EmployeeSkill deletion error");
    }

    @DeleteMapping("/employeeSkills")
    public ResponseEntity<EmployeeSkill> deleteAllEmployeeSkills() {
        employeeSkillService.deleteAllEmployeeSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
