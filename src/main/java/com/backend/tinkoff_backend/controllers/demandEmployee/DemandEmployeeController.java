package com.backend.tinkoff_backend.controllers.demandEmployee;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.services.DemandEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandEmployeeController {

    @Autowired
    DemandEmployeeService demandEmployeeService;

    @PostMapping("/demand/employee")
    public ResponseEntity<Long> createEmployeeOnDemand(@RequestBody DemandAndEmployeeIdPojo pojo) {
        return demandEmployeeService.createEmployeeOnDemand(pojo)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new MyInvalidArgumentException("DemandEmployee creation error"));
    }

    @GetMapping("/demand/{demandId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDemandId(@PathVariable("demandId") long demandId) {
        return new ResponseEntity<>(demandEmployeeService.getEmployeesByDemandId(demandId), HttpStatus.OK);
    }

    @GetMapping("/employee/{demandId}/demands")
    public ResponseEntity<List<Demand>> getDemandsByEmployeesId(@PathVariable("demandId") long demandId) {
        return new ResponseEntity<>(demandEmployeeService.getDemandsByEmployeesId(demandId), HttpStatus.OK);
    }

    @DeleteMapping("/demand/{demandId}/employees")
    public ResponseEntity deleteAllEmployeesOnDemand(@PathVariable("demandId") long demandId) {
        demandEmployeeService.deleteAllEmployeesOnDemand(demandId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
