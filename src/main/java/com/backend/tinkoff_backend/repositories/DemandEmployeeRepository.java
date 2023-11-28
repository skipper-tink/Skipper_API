package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandEmployeeRepository extends JpaRepository<DemandEmployee, Long> {
}
