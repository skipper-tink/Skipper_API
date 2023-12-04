package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.repositories.DemandEmployeeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemandEmployeeService {

    @Autowired
    DemandEmployeeRepository demandEmployeeRepository;

    public void createDemandEmployee(DemandEmployee demandEmployee) {
        demandEmployeeRepository.save(new DemandEmployee(demandEmployee.getDemandId(), demandEmployee.getEmployeeId()));
    }

    public DemandEmployee getDemandEmployeeById(long demandEmployeeId) throws ServiceException {
        Optional<DemandEmployee> demandEmployeeData = demandEmployeeRepository.findById(demandEmployeeId);

        if (demandEmployeeData.isPresent())
            return demandEmployeeData.get();
        throw new ServiceException("No such demandEmployee");
    }
}
