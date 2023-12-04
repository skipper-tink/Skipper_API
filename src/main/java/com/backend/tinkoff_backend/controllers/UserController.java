package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.services.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestParam User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{userLogin}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("userLogin") String userLogin) {
        try {
            return new ResponseEntity<>(userService.getUserByLogin(userLogin), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/users/{userLogin}")
    public ResponseEntity<User> updateUser(@PathVariable("userLogin") String userLogin,
                                           @RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(userLogin, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{userLogin}")
    public ResponseEntity<User> deleteUser(@PathVariable("userLogin") String userLogin) {
        try {
            userService.deleteUser(userLogin);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteAllUsers() {
            userService.deleteAllUsers();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
