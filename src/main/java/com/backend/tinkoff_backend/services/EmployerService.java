package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Long> createEmployer(long userId) {
        return userRepository.findById(userId)
                .map(value -> isAlreadyEmpl(userId)
                        ? new Employer(userId)
                        : null)
                .map(value -> employerRepository.save(value).getUserId());
    }

    public Optional<Employer> getEmployerById(long employerId) {
        return employerRepository.findById(employerId);
    }

    public Optional<Employer> getEmployerByUserId(long userId) {
        return employerRepository.findByUserId(userId);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Optional<Employer> updateEmployer(long employerId, Employer employer) {
        Optional<Employer> opt = employerRepository.findById(employerId);

        return opt
                .map(e -> isAlreadyExist(employer)
                        ? null
                        : mergeEmployer(e, employer))
                .map(e -> employerRepository.save(e));
    }

    public Optional<Employer> deleteEmployer(long employerId) {
        Optional<Employer> opt = employerRepository.findById(employerId);
        return opt
                .map(e -> {
                    employerRepository.deleteById(employerId);
                    return e;
                });
    }

    public void deleteAllEmployers() {
        employerRepository.deleteAll();
    }

    private Employer mergeEmployer(Employer e, Employer employer) {
        e.setUserId(employer.getUserId());
        return e;
    }

    private boolean isAlreadyExist(Employer employer) {
        return employerRepository.findByUserId(employer.getUserId()).isPresent();
    }

    private boolean isAlreadyEmpl(long id) {
        return employeeRepository.findByUserId(id).isEmpty() && employerRepository.findByUserId(id).isEmpty();
    }
}
