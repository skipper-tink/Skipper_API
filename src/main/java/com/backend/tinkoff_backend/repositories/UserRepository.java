package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserLogin(String userLogin);
}
