package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) throws ServiceException {
        Optional<User> userData = userRepository.findByUserLogin(user.getUserLogin());
        if (userData.isPresent()) {
            throw new ServiceException("This login already exists");
        } else {
            User _user = userRepository.save(new User(
                    user.getUserLogin(), user.getUserPassword(),
                    user.getUserName(), user.getUserEmail(),
                    user.getUserPhoneNumber()
            ));
        }
    }
}
