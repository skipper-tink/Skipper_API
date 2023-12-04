package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.services.DemandEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemandEmployeeController {

    @Autowired
    DemandEmployeeService demandEmployeeService;

    @PostMapping("/demandEmployees")
    public ResponseEntity<DemandEmployee> createDemandEmployee(@RequestParam DemandEmployee demandEmployee) {
        demandEmployeeService.createDemandEmployee(demandEmployee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
