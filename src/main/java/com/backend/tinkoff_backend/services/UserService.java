package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.User;
import com.backend.tinkoff_backend.repositories.jpaRepositories.UserRepository;
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
                .map(u -> new User(user))
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
        return userRepository.findById(id)
                .map(u -> mergeUsers(u, user))
                .map(u -> userRepository.save(u));
    }

    public Optional<User> deleteUser(long id) {
        return userRepository.findById(id).stream()
                .peek(user -> userRepository.deleteById(user.getId()))
                .findAny();
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    private User mergeUsers(User u, User user) {
        u.setLogin(user.getLogin());
        u.setPassword(user.getPassword());
        u.setEmployee_id(user.getEmployee_id());
        u.setEmployer_id(user.getEmployer_id());
        return u;
    }
}
