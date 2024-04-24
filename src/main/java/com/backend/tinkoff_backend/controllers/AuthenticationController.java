package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.entities.pojo.AuthenticationPojo;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.AuthenticationService;
import com.backend.tinkoff_backend.services.EmployeeService;
import com.backend.tinkoff_backend.services.EmployerService;
import com.backend.tinkoff_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    EmployerService employerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;

    @GetMapping("/authentication")
    public ResponseEntity<Long> authentication(@RequestBody AuthenticationPojo pojo) {
        Optional<Long> opt = authenticationService.authenticate(pojo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new IllegalArgumentException("Authentication error");
    }

    @PostMapping("/registration/user")
    public ResponseEntity<Long> registerUser(@RequestBody User user) {
        Optional<Long> idData = userService.createUser(user);
        if (idData.isPresent()) {
            return new ResponseEntity<>(idData.get(), HttpStatus.CREATED);
        }
        throw new MyRetrievalFailureException("User with that login already exists");
    }

    @PostMapping("/registration/employee")
    public ResponseEntity<Long> registerEmployee(@RequestBody Employee employee) {
        Optional<Long> idData = employeeService.createEmployee(employee);
        if (idData.isPresent()) {
            return new ResponseEntity<>(idData.get(), HttpStatus.CREATED);
        }
        throw new MyRetrievalFailureException("This user can't be an employee");
    }

    @PostMapping("/registration/employer")
    public ResponseEntity<Long> registerEmployer(@RequestBody long userId) {
        Optional<Long> idData = employerService.createEmployer(userId);
        if (idData.isPresent()) {
            return new ResponseEntity<>(idData.get(), HttpStatus.CREATED);
        }
        throw new MyRetrievalFailureException("This user can't be an employer");
    }
}
