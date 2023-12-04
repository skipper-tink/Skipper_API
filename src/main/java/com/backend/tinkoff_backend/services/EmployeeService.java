package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(new Employee(employee.getUserLogin(), employee.getEmployeeFreeTimePerWeek(),
                employee.getEmployeeThisFreeTimeUntilDate()));
    }

    public Employee getEmployeeById(long employeeId) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent())
            return employeeData.get();
        throw new ServiceException("No such employee");
    }

    public Employee getEmployeeByUserLogin(String userLogin) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findByUserLogin(userLogin);

        if (employeeData.isPresent())
            return employeeData.get();
        throw new ServiceException("No such employee");
    }

    public List<Employee> getAllEmployees() throws ServiceException {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty())
            throw new ServiceException("No employees");
        return employees;
    }

    public Employee updateEmployee(long employeeId, Employee employee) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setUserLogin(employee.getUserLogin());
            _employee.setEmployeeFreeTimePerWeek(employee.getEmployeeFreeTimePerWeek());
            _employee.setEmployeeThisFreeTimeUntilDate(employee.getEmployeeThisFreeTimeUntilDate());
            return employeeRepository.save(_employee);
        }
        throw new ServiceException("No such employee");
    }

    public void deleteEmployee(long employeeId) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return;
        }
        throw new ServiceException("No such employee");
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
