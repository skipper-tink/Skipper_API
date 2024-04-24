package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import com.backend.tinkoff_backend.repositories.EmployeeRepository;
import com.backend.tinkoff_backend.repositories.EmployeeSkillRepository;
import com.backend.tinkoff_backend.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SkillRepository skillRepository;

    public Optional<Long> createEmployeeSkill(EmployeeSkill employeeSkill) {
        if (isAlreadyExist(employeeSkill)) {
            return Optional.of(employeeSkillRepository
                    .save(new EmployeeSkill(employeeSkill.getSkillId(), employeeSkill.getEmployeeId()))
                    .getId());
        }
        return Optional.empty();
    }

    public Optional<EmployeeSkill> getEmployeeSkillById(long employeeSkillId) {
        return employeeSkillRepository.findById(employeeSkillId);
    }

    public List<EmployeeSkill> getAllEmployeeSKills() {
        return employeeSkillRepository.findAll();
    }

    public Optional<EmployeeSkill> updateEmployeeSkill(long employeeSkillId, EmployeeSkill employeeSkill) {
        Optional<EmployeeSkill> employeeSkillData = employeeSkillRepository.findById(employeeSkillId);

        return employeeSkillData
                .map(value -> mergeEmplSkill(value, employeeSkill))
                .map(value -> employeeSkillRepository.save(value));
    }

    public Optional<EmployeeSkill> deleteEmployeeSKill(long employeeSkillId) {
        Optional<EmployeeSkill> employeeSkillData = employeeSkillRepository.findById(employeeSkillId);

        return employeeSkillData
                .map(es -> {
                    employeeSkillRepository.deleteById(employeeSkillId);
                    return es;
                });
    }

    public void deleteAllEmployeeSkills() {
        employeeSkillRepository.deleteAll();
    }

    private EmployeeSkill mergeEmplSkill(EmployeeSkill value, EmployeeSkill employeeSkill) {
        value.setEmployeeId(employeeSkill.getEmployeeId());
        value.setSkillId(employeeSkill.getSkillId());
        return value;
    }

    private boolean isAlreadyExist(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.findByEmployeeIdAndSkillId(employeeSkill.getEmployeeId(), employeeSkill.getSkillId())
                .isPresent();
    }
}
