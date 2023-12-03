package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Employer;
import com.backend.tinkoff_backend.repositories.EmployerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
}
