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
        Optional<User> userData = userRepository.findById(user.getUserLogin());
        if (userData.isPresent())
            throw new ServiceException("This login already exists");
        userRepository.save(user);
    }

    public User getUserByLogin(String userLogin) throws ServiceException {
        Optional<User> userData = userRepository.findById(userLogin);

        if (userData.isPresent())
            return userData.get();
        throw new ServiceException("No such user");
    }


}
