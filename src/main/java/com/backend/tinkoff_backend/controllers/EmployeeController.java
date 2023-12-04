package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestParam Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        try {
            return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
