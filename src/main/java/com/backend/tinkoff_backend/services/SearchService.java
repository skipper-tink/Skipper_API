package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.controllers.search.SearchPojo;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    JdbcEmployeeRepository jdbcEmployeeRepository;

    public List<SearchPojo> getAllEmployeesWithSkills() {
        return jdbcEmployeeRepository.getAllEmployeesWithSkills();
    }
}
