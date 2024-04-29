package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployerRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.UserRepository;
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
        return Optional.of(new Employee(employee))
                .map(e -> employeeRepository.save(e).getId());
    }

    public Optional<Employee> getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> getEmployeesBySpecializationAndQualification(String specialization, String qualification) {
        return employeeRepository.findAllBySpecializationAndQualification(specialization, qualification);
    }

    public List<Employee> getAllEmployees() throws ServiceException {
        return employeeRepository.findAll();
    }

    public Optional<Employee> updateEmployee(long employeeId, Employee employee) {
        return employeeRepository.findById(employeeId)
                .map(e -> mergeEmployee(e, employee))
                .map(e -> employeeRepository.save(e));
    }

    public Optional<Employee> deleteEmployee(long employeeId) {
        return employeeRepository.findById(employeeId).stream()
                .peek(e -> employeeRepository.deleteById(employeeId))
                .findAny();
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }


    private Employee mergeEmployee(Employee employee, Employee value) {
        employee.setName(employee.getName());
        employee.setFreeTimePerWeek(value.getFreeTimePerWeek());
        employee.setFreeTimeUntilDate(value.getFreeTimeUntilDate());
        employee.setQualification(value.getQualification());
        employee.setSpecialization(value.getSpecialization());
        employee.setEmail(employee.getEmail());
        employee.setPhoneNumber(employee.getPhoneNumber());
        return employee;
    }
}
