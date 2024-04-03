package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<Long> createUser(User user) {
        if (userRepository.findByLogin(user.getLogin()).isEmpty()) {
            return Optional.of(userRepository.save(new User(user.getLogin(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoneNumber())).getId());
        } else return Optional.empty();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public User getUserByLogin(String login) {
        Optional<User> userData = userRepository.findByLogin(login);
        if (userData.isPresent())
            return userData.get();
        throw new ServiceException("No such user");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> updateUser(long id, User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            if(!_user.getLogin().equals(user.getLogin())){
                if (userRepository.findByLogin(user.getLogin()).isEmpty())
                    _user.setLogin(user.getLogin());
            } else return Optional.empty();
            _user.setPassword(user.getPassword());
            _user.setName(user.getName());
            _user.setEmail(user.getEmail());
            _user.setPhoneNumber(user.getPhoneNumber());

            return Optional.of(userRepository.save(_user));
        }
        return Optional.empty();
    }

    public Optional<User> deleteUser(long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            userRepository.deleteById(id);
            return userData;
        }
        return Optional.empty();
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
