package com.backend.tinkoff_backend.unused.profile;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Skill;

import java.util.List;

public class ProfilePojo {
    private List<Skill> skills;
    private Employee employee;

    public ProfilePojo(List<Skill> skills, Employee employee) {
        this.skills = skills;
        this.employee = employee;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
