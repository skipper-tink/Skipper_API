package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<Long> createUser(User user) {
        return Optional.of(user)
                .map(u -> mergeUsers(new User(), u))
                .map(u -> userRepository.save(u))
                .map(User::getId);
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> updateUser(long id, User user) {
        Optional<User> userData = userRepository.findById(id);

        return userData
                .map(u -> mergeUsers(u, user))
                .map(u -> userRepository.save(u));
    }

    public Optional<User> deleteUser(long id) {
        Optional<User> userData = userRepository.findById(id);

        return userData
                .map(u -> {
                    userRepository.deleteById(id);
                    return u;
                });
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    private User mergeUsers(User u, User user) {
        u.setLogin(user.getLogin());
        u.setPassword(user.getPassword());
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPhoneNumber(user.getPhoneNumber());
        return u;
    }
}
