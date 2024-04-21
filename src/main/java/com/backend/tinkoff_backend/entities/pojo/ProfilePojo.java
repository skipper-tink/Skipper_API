package com.backend.tinkoff_backend.entities.pojo;

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
}
