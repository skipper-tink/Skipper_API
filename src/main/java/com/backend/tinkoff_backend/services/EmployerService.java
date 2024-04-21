package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import com.backend.tinkoff_backend.repositories.UserRepository;
import org.hibernate.service.spi.ServiceException;
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

    public Employer getEmployerById(long employerId) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent())
            return employerData.get();
        throw new ServiceException("No such employer");
    }

    public Employer getEmployerByUserLogin(long userId) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findByUserId(userId);

        if (employerData.isPresent())
            return employerData.get();
        throw new ServiceException("No such employer");
    }

    public List<Employer> getAllEmployers() throws ServiceException {
        List<Employer> employers = employerRepository.findAll();

        if (employers.isEmpty())
            throw new ServiceException("No employers");
        return employers;
    }

    public Employer updateEmployer(long employerId, Employer employer) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent()) {
            Employer _employer = employerData.get();
            _employer.setUserId(employer.getUserId());
            return employerRepository.save(_employer);
        }
        throw new ServiceException("No such employer");
    }

    public void deleteEmployer(long employerId) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent()) {
            employerRepository.deleteById(employerId);
            return;
        }
        throw new ServiceException("No such employer");
    }

    public void deleteAllEmployers() {
        employerRepository.deleteAll();
    }

    private boolean isAlreadyEmpl(long id) {
        return employeeRepository.findByUserId(id).isEmpty() && employerRepository.findByUserId(id).isEmpty();
    }
}
