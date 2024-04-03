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
        if (userRepository.findById(employee.getUserId()).isPresent()) {
            if (employeeRepository.findByUserId(employee.getUserId()).isEmpty() && employerRepository.findByUserId(employee.getUserId()).isEmpty()) {
                return Optional.of(employeeRepository.save(new Employee(employee.getUserId(), employee.getFreeTimePerWeek(),
                        employee.getFreeTimeUntilDate(), employee.getSpecialization(),
                        employee.getQualification())).getId());
            }
        }
        return Optional.empty();
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
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            if (_employee.getUserId() != employee.getUserId()) {
                if (userRepository.findById(employee.getUserId()).isPresent()) {
                    if (employeeRepository.findByUserId(employee.getUserId()).isEmpty() && employerRepository.findByUserId(employee.getUserId()).isEmpty()) {
                        _employee.setUserId(employee.getUserId());
                    } else return Optional.empty();
                } else return Optional.empty();
            }
            _employee.setFreeTimePerWeek(employee.getFreeTimePerWeek());
            _employee.setFreeTimeUntilDate(employee.getFreeTimeUntilDate());
            return Optional.of(employeeRepository.save(_employee));
        }
        return Optional.empty();
    }

    public Optional<Employee> deleteEmployee(long employeeId) {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        if (employeeData.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return employeeData;
        }
        return Optional.empty();
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
