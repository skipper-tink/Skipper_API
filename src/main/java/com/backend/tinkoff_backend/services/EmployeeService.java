package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    UserRepository userRepository;

    public Optional<Long> createEmployee(Employee employee) {
        return userRepository.findById(employee.getUserId())
                .map(value -> isAlreadyEmpl(value.getId())
                        ? mergeEmployee(new Employee(), employee)
                        : null)
                .map(value -> employeeRepository.save(value).getUserId());
    }

    public Optional<Employee> getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Optional<Employee> getEmployeeByUserId(long userId) {
        return employeeRepository.findByUserId(userId);
    }

    public List<Employee> getAllEmployees() throws ServiceException {
        return employeeRepository.findAll();
    }

    public Optional<Employee> updateEmployee(long employeeId, Employee employee) {
        return employeeRepository.findById(employeeId)
                .map(value -> {
                    long userId = value.getUserId();
                    Employee res = mergeEmployee(value, employee);
                    res.setUserId(userId);
                    return res;
                })
                .map(value -> employeeRepository.save(value));
    }

    public Optional<Employee> deleteEmployee(long employeeId) {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        return employeeData
                .map(value -> {
                    employeeRepository.deleteById(employeeId);
                    return value;
                });
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    private boolean isAlreadyEmpl(long id) {
        return employeeRepository.findByUserId(id).isEmpty() && employerRepository.findByUserId(id).isEmpty();
    }

    private Employee mergeEmployee(Employee employee, Employee value) {
        employee.setUserId(value.getUserId());
        employee.setFreeTimePerWeek(value.getFreeTimePerWeek());
        employee.setFreeTimeUntilDate(value.getFreeTimeUntilDate());
        employee.setQualification(value.getQualification());
        employee.setSpecialization(value.getSpecialization());
        return employee;
    }
}
