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

@RestController
@RequestMapping("/api")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @PostMapping("/employers")
    public ResponseEntity<Long> createEmployer(@RequestBody Employer employer) {
        return employerService.createEmployer(employer)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new MyInvalidArgumentException("Employer creation error"));
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long employerId) {
        return employerService.getEmployerById(employerId)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Employer getting by id error"));
    }

    @GetMapping("/employers")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        return new ResponseEntity<>(employerService.getAllEmployers(), HttpStatus.OK);
    }

    @PutMapping("/employers/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable("id") long employerId,
                                                   @RequestBody Employer employer) {
        return employerService.updateEmployer(employerId, employer)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Employer updating error"));
    }

    @DeleteMapping("/employers/{id}")
    public ResponseEntity<Employer> deleteEmployer(@PathVariable("id") long employerId) {
        return employerService.deleteEmployer(employerId)
                .map(e -> new ResponseEntity<>(e, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Employer deletion error"));
    }

    @DeleteMapping("/employers")
    public ResponseEntity<Employer> deleteAllEmployers() {
        employerService.deleteAllEmployers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
