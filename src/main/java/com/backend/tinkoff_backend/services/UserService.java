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

    public List<User> getAllUsers() throws ServiceException {
        List<User> users = userRepository.findAll();

        if (users.isEmpty())
            throw new ServiceException("No users");
        return users;
    }

    public User updateUser(String userLogin, User user) throws ServiceException {
        Optional<User> userData = userRepository.findById(userLogin);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setUserPassword(user.getUserPassword());
            _user.setUserName(user.getUserName());
            _user.setUserEmail(user.getUserEmail());
            _user.setUserPhoneNumber(user.getUserPhoneNumber());

            return userRepository.save(_user);
        }
        throw new ServiceException("No such user");
    }

    public void deleteUser(String userLogin) throws ServerException {
        Optional<User> userData = userRepository.findById(userLogin);

        if (userData.isPresent()) {
            userRepository.deleteById(userLogin);
            return;
        }
        throw new ServerException("No such user");
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
