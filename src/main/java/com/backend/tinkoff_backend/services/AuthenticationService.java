package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.controllers.authentication.AuthenticationRequestPojo;
import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.controllers.authentication.AuthenticationPojo;
import com.backend.tinkoff_backend.repositories.jpaRepositories.UserRepository;
import com.backend.tinkoff_backend.services.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final EmployeeService employeeService;
    private final EmployerService employerService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserService userService, EmployeeService employeeService, EmployerService employerService, UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.employeeService = employeeService;
        this.employerService = employerService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<AuthenticationRequestPojo> authenticate(AuthenticationPojo pojo) {
        return userRepository.findByLogin(pojo.getLogin())
                .map(u -> checkPassword(u, pojo.getPassword()))
                .map(u -> formulateResult(u));
    }

    private AuthenticationRequestPojo formulateResult(User u) {
        if (u.getEmployee_id() == 0 && u.getEmployer_id() == 0) {
            return new AuthenticationRequestPojo("user", u.getId());
        }
        if (u.getEmployee_id() != 0 ^ u.getEmployer_id() != 0) {
            return new AuthenticationRequestPojo((
                    u.getEmployee_id() != 0) ? "employee" : "employer",
                    (u.getEmployee_id() != 0) ? u.getEmployee_id() : u.getEmployer_id()
            );
        }
        return null;
    }

    private User checkPassword(User u, String password) {
        if (u.getPassword().equals(password)) return u;
        return null;
    }
}

