package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
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

    @PostMapping("/employeeSkills")
    public ResponseEntity<EmployeeSkill> createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        employeeSkillService.createEmployeeSkill(employeeSkill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> getEmployeeSkillById(@PathVariable("id") long employeeSkillId) {
        try {
            return new ResponseEntity<>(employeeSkillService.getEmployeeSkillById(employeeSkillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/employeeSkills/{employeeId}")
    public ResponseEntity<List<EmployeeSkill>> getEmployeeSkillsByEmployeeId(@PathVariable("employeeId") long employeeId) {
        try {
            return new ResponseEntity<>(employeeSkillService.getEmployeeSkillsByEmployeeId(employeeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employeeSkills/{skillId}")
    public ResponseEntity<List<EmployeeSkill>> getEmployeeSkillsBySkillId(@PathVariable("skillId") long skillId) {
        try {
            return new ResponseEntity<>(employeeSkillService.getEmployeeSkillsBySkillId(skillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employeeSkills")
    public ResponseEntity<List<EmployeeSkill>> getAllEmployeeSkills() {
        try {
            return new ResponseEntity<>(employeeSkillService.getAllEmployeeSKills(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> updateEmployeeSkill(@PathVariable("id") long employeeSkillId, @RequestBody EmployeeSkill employeeSkill) {
        try {
            return new ResponseEntity<>(employeeSkillService.updateEmployeeSkill(employeeSkillId, employeeSkill), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employeeSkills/{id}")
    public ResponseEntity<EmployeeSkill> deleteEmployeeSKill(@PathVariable("id") long employeeSkillId) {
        try {
            employeeSkillService.deleteEmployeeSKill(employeeSkillId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employeeSkills")
    public ResponseEntity<EmployeeSkill> deleteAllEmployeeSkills() {
        employeeSkillService.deleteAllEmployeeSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
