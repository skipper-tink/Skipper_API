package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        Optional<Long> userData = userService.createUser(user);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.CREATED);
        }
        throw new MyInvalidArgumentException("User creation error");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        Optional<User> userData = userService.getUserById(id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("User getting error");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,
                                           @RequestBody User user) {
        Optional<User> userData = userService.updateUser(id, user);
        if(userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("User updating error");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        Optional<User> userData = userService.deleteUser(id);
        if (userData.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new MyRetrievalFailureException("User deleting error");
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteAllUsers() {
        userService.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
