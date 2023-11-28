package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
