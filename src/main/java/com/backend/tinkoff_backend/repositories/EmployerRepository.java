package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findByUserId(long userId);
}
