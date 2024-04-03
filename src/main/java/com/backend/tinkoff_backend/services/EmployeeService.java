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

    public long createEmployee(Employee employee) {
        if (employeeRepository.findByUserId(employee.getUserId()).isEmpty()) {
            return employeeRepository.save(new Employee(employee.getUserId(), employee.getFreeTimePerWeek(),
                    employee.getFreeTimeUntilDate())).getId();
        } else throw new ServiceException("This user already employee");
    }

    public Employee getEmployeeById(long employeeId) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent())
            return employeeData.get();
        throw new ServiceException("No such employee");
    }

    public Employee getEmployeeByUserId(long userId) throws ServiceException {
        Optional<Employee> employeeData = employeeRepository.findByUserId(userId);

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
            _employee.setUserId(employee.getUserId());
            _employee.setFreeTimePerWeek(employee.getFreeTimePerWeek());
            _employee.setFreeTimeUntilDate(employee.getFreeTimeUntilDate());
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
