package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.EmployeeSkill;
import com.backend.tinkoff_backend.repositories.EmployeeSkillRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSkillService {

    @Autowired
    EmployeeSkillRepository employeeSkillRepository;

    public void createEmployeeSkill(EmployeeSkill employeeSkill) {
        employeeSkillRepository.save(new EmployeeSkill(employeeSkill.getSkillId(), employeeSkill.getEmployeeId()));
    }

    public EmployeeSkill getEmployeeSkillById(long employeeSkillId) throws ServiceException {
        Optional<EmployeeSkill> employeeSkillData = employeeSkillRepository.findById(employeeSkillId);

        if (employeeSkillData.isPresent())
            return employeeSkillData.get();
        throw new ServiceException("No such employeeSkill");
    }

    public List<EmployeeSkill> getEmployeeSkillsByEmployeeId(long employeeId) throws ServiceException {
        List<EmployeeSkill> employeeSkills = employeeSkillRepository.findAllByEmployeeId(employeeId);

        if (employeeSkills.isEmpty())
            throw new ServiceException("This employee doesn't have any skills");
        return employeeSkills;
    }

    public List<EmployeeSkill> getEmployeeSkillsBySkillId(long skillId) throws ServiceException {
        List<EmployeeSkill> employeeSkills = employeeSkillRepository.findAllBySkillId(skillId);

        if (employeeSkills.isEmpty())
            throw new ServiceException("Nobody have this skill");
        return employeeSkills;
    }

    public List<EmployeeSkill> getAllEmployeeSKills() throws ServiceException {
        List<EmployeeSkill> employeeSkills = employeeSkillRepository.findAll();

        if (employeeSkills.isEmpty())
            throw new ServiceException("No employeeSkills");
        return employeeSkills;
    }

    public EmployeeSkill updateEmployeeSkill(long employeeSkillId, EmployeeSkill employeeSkill) throws ServiceException {
        Optional<EmployeeSkill> employeeSkillData = employeeSkillRepository.findById(employeeSkillId);

        if (employeeSkillData.isPresent()) {
            EmployeeSkill _employeeSkill = employeeSkillData.get();
            _employeeSkill.setEmployeeId(employeeSkill.getEmployeeId());
            _employeeSkill.setSkillId(employeeSkill.getSkillId());
            return employeeSkillRepository.save(_employeeSkill);
        }
        throw new ServiceException("No such employeeSkill");
    }

    public void deleteEmployeeSKill(long employeeSkillId) throws ServiceException {
        Optional<EmployeeSkill> employeeSkillData = employeeSkillRepository.findById(employeeSkillId);

        if (employeeSkillData.isPresent()) {
            employeeSkillRepository.deleteById(employeeSkillId);
            return;
        }
        throw new ServiceException("No such employeeSkill");
    }

    public void deleteAllEmployeeSkills() {
        employeeSkillRepository.deleteAll();
    }
}
