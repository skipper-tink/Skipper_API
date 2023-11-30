package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestParam User user){
        return null;
    }


}
