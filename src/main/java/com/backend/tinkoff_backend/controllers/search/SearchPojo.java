package com.backend.tinkoff_backend.controllers.search;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Skill;

import java.util.List;

public class SearchPojo {
    private Employee employee;
    private List<Skill> skills;

    public SearchPojo() {}

    public SearchPojo(Employee employee, List<Skill> skills) {
        this.employee = employee;
        this.skills = skills;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
