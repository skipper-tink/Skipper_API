package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcEmployeeRepository;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcSkillRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.EmployeeSkillRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JdbcEmployeeRepository jdbcEmployeeRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    JdbcSkillRepository jdbcSkillRepository;

    public void createSkillsOnEmployee(long employeeId, List<Long> skillIds) {
        employeeSkillRepository.saveAll(skillIds.stream().map(id -> new EmployeeSkill(id, employeeId)).toList());
    }

    public List<Skill> getSkillsByEmployeeId(long employeeId) {
        return jdbcSkillRepository.getSkillsByEmployeeId(employeeId);
    }

    public void updateSkillsOnEmployee(long employeeId, List<Long> skillIds) {
        employeeSkillRepository.deleteAll();
        employeeSkillRepository.saveAll(skillIds.stream().map(id -> new EmployeeSkill(id, employeeId)).toList());
    }

    public void deleteSkillsByEmployeeId(long employeeId) {
        jdbcEmployeeRepository.deleteSkillsByEmployeeId(employeeId);
    }

    public void deleteAllEmployeeSkills() {
        employeeSkillRepository.deleteAll();
    }
}
