package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.repositories.DemandEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandEmployeeService {

    @Autowired
    DemandEmployeeRepository demandEmployeeRepository;

    public Optional<Long> createDemandEmployee(DemandEmployee demandEmployee) {
        if (!alreadyExist(demandEmployee)) {
            return Optional.of(demandEmployeeRepository
                    .save(new DemandEmployee(demandEmployee.getDemandId(), demandEmployee.getEmployeeId()))
                    .getId());
        }
        return Optional.empty();
    }

    public Optional<DemandEmployee> getDemandEmployeeById(long demandEmployeeId) {
        return demandEmployeeRepository.findById(demandEmployeeId);
    }

    public List<DemandEmployee> getDemandEmployeesByEmployeeId(long employeeId) {
        return demandEmployeeRepository.findAllByEmployeeId(employeeId);
    }

    public List<DemandEmployee> getDemandEmployeeByDemandId(long demandId) {
        return demandEmployeeRepository.findAllByDemandId(demandId);
    }

    public List<DemandEmployee> getAllDemandEmployees() {
        return demandEmployeeRepository.findAll();
    }

    public Optional<DemandEmployee> updateDemandEmployee(long demandEmployeeId, DemandEmployee demandEmployee) {
        Optional<DemandEmployee> opt = demandEmployeeRepository.findById(demandEmployeeId);

        return opt
                .map(de -> mergeDemandEmployee(de, demandEmployee))
                .map(de -> demandEmployeeRepository.save(de));
    }

    public Optional<DemandEmployee> deleteDemandEmployee(long demandEmployeeId) {
        Optional<DemandEmployee> opt = demandEmployeeRepository.findById(demandEmployeeId);

        return opt.map(de -> {
            demandEmployeeRepository.deleteById(demandEmployeeId);
            return de;
        });
    }

    public void deleteAllDemandEmployees() {
        demandEmployeeRepository.deleteAll();
    }

    private DemandEmployee mergeDemandEmployee(DemandEmployee de, DemandEmployee demandEmployee) {
        de.setDemandId(demandEmployee.getDemandId());
        de.setEmployeeId(demandEmployee.getEmployeeId());
        return de;
    }

    private boolean alreadyExist(DemandEmployee demandEmployee) {
        return demandEmployeeRepository.findByDemandIdAndEmployeeId(demandEmployee.getDemandId(), demandEmployee.getEmployeeId()).isPresent();
    }
}
