package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.DemandEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemandEmployeeController {

    @Autowired
    DemandEmployeeService demandEmployeeService;

    @PostMapping("/demandEmployees")
    public ResponseEntity<Long> createDemandEmployee(@RequestBody DemandEmployee demandEmployee) {
        Optional<Long> opt = demandEmployeeService.createDemandEmployee(demandEmployee);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        }
        throw new MyInvalidArgumentException("DemandEmployee creation error");
    }

    @GetMapping("/demandEmployees/{id}")
    public ResponseEntity<DemandEmployee> getDemandEmployeeById(@PathVariable("id") long demandEmployeeId) {
        Optional<DemandEmployee> opt = demandEmployeeService.getDemandEmployeeById(demandEmployeeId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("DemandEmployee getting by id error");
    }

    @GetMapping("/demandEmployees/{employeeId}")
    public ResponseEntity<List<DemandEmployee>> getDemandEmployeesByEmployeeId(@PathVariable("employeeId")
                                                                               long employeeId) {
        return new ResponseEntity<>(demandEmployeeService.getDemandEmployeesByEmployeeId(employeeId),
                HttpStatus.OK);
    }

    @GetMapping("/demandEmployees/{demandId}")
    public ResponseEntity<List<DemandEmployee>> getDemandEmployeesByDemandId(@PathVariable("demandId")
                                                                             long demandId) {
        return new ResponseEntity<>(demandEmployeeService.getDemandEmployeeByDemandId(demandId),
                HttpStatus.OK);
    }

    @GetMapping("/demandEmployees")
    public ResponseEntity<List<DemandEmployee>> getAllDemandEmployees() {
        return new ResponseEntity<>(demandEmployeeService.getAllDemandEmployees(), HttpStatus.OK);
    }

    @PutMapping("/demandEmployees/{id}")
    public ResponseEntity<DemandEmployee> updateDemandEmployee(@PathVariable("id") long demandEmployeeId,
                                                               DemandEmployee demandEmployee) {
        Optional<DemandEmployee> opt = demandEmployeeService.updateDemandEmployee(demandEmployeeId,
                demandEmployee);
        if(opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("DemandEmployee updating error");
    }

    @DeleteMapping("/demandEmployees/{id}")
    public ResponseEntity<DemandEmployee> deleteDemandEmployee(@PathVariable("id") long demandEmployeeId) {
        Optional<DemandEmployee> opt = demandEmployeeService.deleteDemandEmployee(demandEmployeeId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("DemandEmployee deletion error");
    }

    @DeleteMapping("/demandEmployees")
    public ResponseEntity<DemandEmployee> deleteAllDemandEmployees() {
        demandEmployeeService.deleteAllDemandEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
