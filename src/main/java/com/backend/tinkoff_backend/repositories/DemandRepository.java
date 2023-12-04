package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand, Long> {
    List<Demand> findAllByProjectId(long projectId);
}
