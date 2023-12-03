package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Employer getEmployerByUserLogin(String userLogin) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findByUserLogin(userLogin);

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
            _employer.setUserLogin(employer.getUserLogin());
            return employerRepository.save(_employer);
        }
        throw new ServiceException("No such employer");
    }

    public void deleteEmployer(long employerId) throws ServiceException {
        Optional<Employer> employerData = employerRepository.findById(employerId);

        if (employerData.isPresent())
            employerRepository.deleteById(employerId);
        throw new ServiceException("No such employer");
    }

    public void deleteAllEmployers() throws ServiceException {
        employerRepository.deleteAll();
    }
}
