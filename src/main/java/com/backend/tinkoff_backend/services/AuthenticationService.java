package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
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


    //Не настроен вариант неправильного пароля и неправильного логина
    public long authenticate(User user) {
        Optional<User> userData = userRepository.findByLogin(user.getLogin());
        if(userData.isPresent()) {
            if (userData.get().getPassword().equals(user.getPassword())) {
                return userData.get().getId();
            } else throw new ServiceException("Bad request");
        } else throw new ServiceException("Bad request");
    }
}

