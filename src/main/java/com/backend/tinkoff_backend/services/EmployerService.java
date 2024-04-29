package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployerRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.UserRepository;
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

    public Optional<Long> createEmployer(Employer employer) {
        return Optional.of(new Employer(employer))
                .map(e -> employerRepository.save(e).getId());
    }

    public Optional<Employer> getEmployerById(long employerId) {
        return employerRepository.findById(employerId);
    }

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Optional<Employer> updateEmployer(long employerId, Employer employer) {
        return employerRepository.findById(employerId)
                .map(e -> mergeEmployer(e, employer))
                .map(e -> employerRepository.save(e));
    }

    public Optional<Employer> deleteEmployer(long employerId) {
        return employerRepository.findById(employerId).stream()
                .peek(e -> employerRepository.deleteById(employerId))
                .findAny();
    }

    public void deleteAllEmployers() {
        employerRepository.deleteAll();
    }

    private Employer mergeEmployer(Employer e, Employer employer) {
        e.setEmail(employer.getEmail());
        e.setName(employer.getName());
        e.setPhoneNumber(employer.getPhoneNumber());
        return e;
    }
}
