package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployerService {

    @Autowired
    EmployerRepository employerRepository;

    public void createEmployer(String userLogin) throws ServiceException {
        try {
            employerRepository.save(new Employer(userLogin));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Employer getEmployerById(long employerId) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent())
            return employerData.get();
        throw new ServiceException("No such employer");
    }

    public Employer updateEmployer(long employerId, Employer employer) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent()) {
            Employer _employer = employerData.get();
            _employer.setUser_userLogin(employer.getUser_userLogin());
            return employerRepository.save(_employer);
        }
        throw new ServiceException("No such employer");
    }
}
