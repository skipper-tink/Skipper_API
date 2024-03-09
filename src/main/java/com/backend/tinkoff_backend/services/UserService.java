package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) throws ServiceException {
            userRepository.save(new User(user.getLogin(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoneNumber()));
    }

    public User getUserById(long id) throws ServiceException {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent())
            return userData.get();
        throw new ServiceException("No such user");
    }

    public List<User> getAllUsers() throws ServiceException {
        List<User> users = userRepository.findAll();

        if (users.isEmpty())
            throw new ServiceException("No users");
        return users;
    }

    public User updateUser(long id, User user) throws ServiceException {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setPassword(user.getPassword());
            _user.setName(user.getName());
            _user.setEmail(user.getEmail());
            _user.setPhoneNumber(user.getPhoneNumber());

            return userRepository.save(_user);
        }
        throw new ServiceException("No such user");
    }

    public void deleteUser(long id) throws ServerException {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            userRepository.deleteById(id);
            return;
        }
        throw new ServerException("No such user");
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
