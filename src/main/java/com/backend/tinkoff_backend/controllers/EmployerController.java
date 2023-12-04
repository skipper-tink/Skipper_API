package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employer;
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
    public ResponseEntity<Employer> createEmployer(@RequestParam String User_userLogin) {
        try {
            employerService.createEmployer(User_userLogin);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long employerId) {
        try {
            return new ResponseEntity<>(employerService.getEmployerById(employerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employers/{userLogin}")
    public ResponseEntity<Employer> getEmployerByUserLogin(@PathVariable("userLogin") String userLogin) {
        try {
            return new ResponseEntity<>(employerService.getEmployerByUserLogin(userLogin), HttpStatus.OK);
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
