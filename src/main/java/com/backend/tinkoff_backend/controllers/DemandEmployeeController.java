package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.services.DemandEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/demandEmployees/{id}")
    public ResponseEntity<DemandEmployee> getDemandEmployeeById(@PathVariable("id") long demandEmployeeId) {
        try {
            return new ResponseEntity<>(demandEmployeeService.getDemandEmployeeById(demandEmployeeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demandEmployees/{employeeId}")
    public ResponseEntity<List<DemandEmployee>> getDemandEmployeesByEmployeeId(@PathVariable("employeeId")
                                                                            long employeeId) {
        try {
            return new ResponseEntity<>(demandEmployeeService.getDemandEmployeesByEmployeeId(employeeId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demandEmployees/{demandId}")
    public ResponseEntity<List<DemandEmployee>> getDemandEmployeesByDemandId(@PathVariable("demandId")
                                                                             long demandId) {
        try {
            return new ResponseEntity<>(demandEmployeeService.getDemandEmployeeByDemandId(demandId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demandEmployees")
    public ResponseEntity<List<DemandEmployee>> getAllDemandEmployees() {
        try {
            return new ResponseEntity<>(demandEmployeeService.getAllDemandEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/demandEmployees/{id}")
    public ResponseEntity<DemandEmployee> updateDemandEmployee(@PathVariable("id") long demandEmployeeId,
                                                               DemandEmployee demandEmployee) {
        try {
            return new ResponseEntity<>(demandEmployeeService.updateDemandEmployee(demandEmployeeId,
                    demandEmployee), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
