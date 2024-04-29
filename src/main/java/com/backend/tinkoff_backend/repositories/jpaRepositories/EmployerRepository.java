package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
