package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.controllers.demandEmployee.DemandAndEmployeeIdPojo;
import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.entities.DemandEmployee;
import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcDemandRepository;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcEmployeeRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.DemandEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandEmployeeService {

    @Autowired
    DemandEmployeeRepository demandEmployeeRepository;
    @Autowired
    JdbcDemandRepository jdbcDemandRepository;
    @Autowired
    JdbcEmployeeRepository jdbcEmployeeRepository;

    public Optional<Long> createEmployeeOnDemand(DemandAndEmployeeIdPojo pojo) {
        return Optional.of(new DemandEmployee(pojo.getDemandId(), pojo.getEmployeeId()))
                .map(de -> demandEmployeeRepository.save(de).getId());
    }

    public List<Employee> getEmployeesByDemandId(long demandId) {
        return jdbcEmployeeRepository.getEmployeesByDemandId(demandId);
    }

    public List<Demand> getDemandsByEmployeesId(long employeeId) {
        return jdbcDemandRepository.getDemandsByEmployeeId(employeeId);
    }

    public void deleteAllEmployeesOnDemand(long demandId) {
        jdbcDemandRepository.deleteAllEmployeesOnDemandId(demandId);
    }
}
