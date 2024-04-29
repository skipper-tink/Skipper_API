package com.backend.tinkoff_backend.controllers.authentication;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
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

    @GetMapping("/authentication")
    public ResponseEntity<AuthenticationRequestPojo> authentication(@RequestBody AuthenticationPojo pojo) {
        return authenticationService.authenticate(pojo)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new IllegalArgumentException("Authentication error"));
    }

    @PostMapping("/registration/user")
    public ResponseEntity<Long> registerUser(@RequestBody User user) {
        return userService.createUser(user)
                .map(u -> new ResponseEntity<>(u, HttpStatus.CREATED))
                .orElseThrow(() -> new MyRetrievalFailureException("User registration error"));
    }

    @PostMapping("/registration/employee/{userId}")
    public ResponseEntity<Long> registerEmployee(@PathVariable("userId") long userId, @RequestBody Employee employee) {
        return userService.getUserById(userId)
                .filter(this::canRegister)
                .map(u -> userService.updateUser(
                        userId,
                        mergeUserEmployeeId(u, employeeService.createEmployee(employee).get())
                        ).get().getEmployee_id())
                .map(employeeId -> new ResponseEntity<>(employeeId, HttpStatus.CREATED))
                .orElseThrow(() -> new MyRetrievalFailureException("Employee registration error"));
    }

    @PostMapping("/registration/employer/{userId}")
    public ResponseEntity<Long> registerEmployer(@PathVariable("userId") long userId, @RequestBody Employer employer) {
        return userService.getUserById(userId)
                .filter(this::canRegister)
                .map(u -> userService.updateUser(
                        userId,
                        mergeUserEmployerId(u, employerService.createEmployer(employer).get())
                ).get().getEmployer_id())
                .map(employerId -> new ResponseEntity<>(employerId, HttpStatus.CREATED))
                .orElseThrow(() -> new MyRetrievalFailureException("Employer registration error"));
    }

    private User mergeUserEmployerId(User u, Long employerId) {
        u.setEmployer_id(employerId);
        return u;
    }

    private User mergeUserEmployeeId(User u, Long employeeId) {
        u.setEmployee_id(employeeId);
        return u;
    }

    private boolean canRegister(User u) {
        return u.getEmployee_id() == 0 && u.getEmployer_id() == 0;
    }
}
