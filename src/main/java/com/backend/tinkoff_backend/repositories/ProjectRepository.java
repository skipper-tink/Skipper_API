package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
