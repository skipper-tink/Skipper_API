package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.services.AuthenticationService;
import com.backend.tinkoff_backend.services.EmployeeService;
import com.backend.tinkoff_backend.services.EmployerService;
import com.backend.tinkoff_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

//Не настроен вариант неправильного пароля и неправильного логина
    @GetMapping("/authorisation")
    public ResponseEntity<Long> authentication(@RequestBody User user) {
        try {
            return new ResponseEntity<>(authenticationService.authenticate(user), HttpStatus.OK);
        } catch (SecurityException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/registration/user")
    public ResponseEntity<Long> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/registration/employee")
    public ResponseEntity<Long> registerEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/registration/employer")
    public ResponseEntity<Long> registerEmployer(@RequestBody long userId) {
        return new ResponseEntity<>(employerService.createEmployer(userId), HttpStatus.CREATED);
    }
}
