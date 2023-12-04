package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.repositories.DemandEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandEmployeeService {

    @Autowired
    DemandEmployeeRepository demandEmployeeRepository;

    public void createDemandEmployee(DemandEmployee demandEmployee) {
        demandEmployeeRepository.save(new DemandEmployee(demandEmployee.getDemandId(), demandEmployee.getEmployeeId()));
    }
}
