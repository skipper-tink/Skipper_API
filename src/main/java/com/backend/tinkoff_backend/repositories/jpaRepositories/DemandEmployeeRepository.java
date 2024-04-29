package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DemandEmployeeRepository extends JpaRepository<DemandEmployee, Long> {
    Optional<DemandEmployee> findByDemandIdAndEmployeeId(long demandId, long employeeId);
    List<DemandEmployee> findAllByEmployeeId(long employeeId);
    List<DemandEmployee> findAllByDemandId(long demandId);
}
