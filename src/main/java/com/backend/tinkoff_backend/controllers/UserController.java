package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import com.backend.tinkoff_backend.services.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
    }

    /*@GetMapping("/users/{userLogin}")
    public ResponseEntity<User> getUserByLogin(@PathVariable("userLogin") String userLogin){
        Optional<User> userData = userRepository.findByUserLogin(userLogin);

        return userData.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    /*@PutMapping("/users/{userLogin}")
    public ResponseEntity<User> updateUser(@PathVariable("userLogin") String userLogin,
                                           @RequestBody User user) {
        Optional<User> userData = userRepository.findByUserLogin(userLogin);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setUserPassword();
        }
    }*/
}
