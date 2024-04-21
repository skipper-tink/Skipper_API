package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @PostMapping("/employers")
    public ResponseEntity<Long> createEmployer(@RequestBody long userId) {
        Optional<Long> employerData = employerService.createEmployer(userId);
        if (employerData.isPresent()) {
            return new ResponseEntity<>(employerData.get(), HttpStatus.CREATED);
        }
        throw new MyInvalidArgumentException("This user can't be an employer");
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long employerId) {
        try {
            return new ResponseEntity<>(employerService.getEmployerById(employerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employers/{userId}")
    public ResponseEntity<Employer> getEmployerByUserLogin(@PathVariable("userId") long userId) {
        try {
            return new ResponseEntity<>(employerService.getEmployerByUserLogin(userId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employers")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        try {
            return new ResponseEntity<>(employerService.getAllEmployers(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employers/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable("id") long employerId,
                                                   @RequestBody Employer employer) {
        try {
            return new ResponseEntity<>(employerService.updateEmployer(employerId, employer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employers/{id}")
    public ResponseEntity<Employer> deleteEmployer(@PathVariable("id") long employerId) {
        try {
            employerService.deleteEmployer(employerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employers")
    public ResponseEntity<Employer> deleteAllEmployers() {
            employerService.deleteAllEmployers();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
