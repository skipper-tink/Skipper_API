package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandEmployeeRepository extends JpaRepository<DemandEmployee, Long> {
    List<DemandEmployee> findAllByEmployeeId(long employeeId);
    List<DemandEmployee> findAllByDemandId(long demandId);
}
