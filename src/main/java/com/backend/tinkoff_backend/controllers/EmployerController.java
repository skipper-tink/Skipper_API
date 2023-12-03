package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
