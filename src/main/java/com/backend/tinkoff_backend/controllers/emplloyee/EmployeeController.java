package com.backend.tinkoff_backend.controllers.emplloyee;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Long> createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new MyInvalidArgumentException("Employee creation error"));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return employeeService.getEmployeeById(employeeId)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Employee getting by id error"));
    }

    @GetMapping("/employees/{specializationAndQualification}")
    public ResponseEntity<List<Employee>> getEmployeeBySpecializationAndQualification
            (@PathVariable("specializationAndQualification") SpecializationAndQualificationPojo saq) {
        return new ResponseEntity<>(employeeService.getEmployeesBySpecializationAndQualification(
                saq.getSpecialization(),
                saq.getQualification()), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId, employee)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Employee updating error"));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long employeeId) {
        return employeeService.deleteEmployee(employeeId)
                .map(e -> new ResponseEntity<>(e, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Employee deletion error"));
    }

    @DeleteMapping("/employees")
    public ResponseEntity<Employee> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
