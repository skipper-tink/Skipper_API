package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.entities.pojo.AuthenticationPojo;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployerService employerService;
    @Autowired
    UserRepository userRepository;

    public Optional<Long> authenticate(AuthenticationPojo pojo) {
        Optional<User> opt = userRepository.findByLogin(pojo.getLogin());

        return opt.map(u -> checkPassword(u, pojo.getPassword()));
    }

    private Long checkPassword(User u, String password) {
        if (u.getPassword().equals(password)) return u.getId();
        return null;
    }
}

