package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
