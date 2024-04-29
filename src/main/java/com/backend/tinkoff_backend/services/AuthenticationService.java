package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.controllers.authentication.AuthenticationRequestPojo;
import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.controllers.authentication.AuthenticationPojo;
import com.backend.tinkoff_backend.repositories.jpaRepositories.UserRepository;
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

