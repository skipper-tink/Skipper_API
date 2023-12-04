package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(new Employee(employee.getUserLogin(), employee.getEmployeeFreeTimePerWeek(),
                employee.getEmployeeThisFreeTimeUntilDate()));
    }
}
