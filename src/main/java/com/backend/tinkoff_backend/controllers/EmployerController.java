package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
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
        Optional<Long> opt = employerService.createEmployer(userId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        }
        throw new MyInvalidArgumentException("Employer creation error");
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long employerId) {
        Optional<Employer> opt = employerService.getEmployerById(employerId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("Employer getting by id error");
    }

    @GetMapping("/employers/{userId}")
    public ResponseEntity<Employer> getEmployerByUserId(@PathVariable("userId") long userId) {
        Optional<Employer> opt = employerService.getEmployerByUserId(userId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("Employer getting by user id error");
    }

    @GetMapping("/employers")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        return new ResponseEntity<>(employerService.getAllEmployers(), HttpStatus.OK);
    }

    @PutMapping("/employers/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable("id") long employerId,
                                                   @RequestBody Employer employer) {
        Optional<Employer> opt = employerService.updateEmployer(employerId, employer);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("Employer updating error");
    }

    @DeleteMapping("/employers/{id}")
    public ResponseEntity<Employer> deleteEmployer(@PathVariable("id") long employerId) {
        Optional<Employer> opt = employerService.deleteEmployer(employerId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("Employer deletion error");
    }

    @DeleteMapping("/employers")
    public ResponseEntity<Employer> deleteAllEmployers() {
        employerService.deleteAllEmployers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
