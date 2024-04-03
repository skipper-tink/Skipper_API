package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SprEmployeeSkill")
public class EmployeeSkill {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "sprSkillId",
            referencedColumnName = "id",
            nullable = false)
    private long skillId;

    @JoinColumn(name = "sprEmployeeId",
            referencedColumnName = "id",
            nullable = false)
    private long employeeId;

    public EmployeeSkill() {
    }

    public EmployeeSkill(long skillId,
                         long employeeId) {
        this.skillId = skillId;
        this.employeeId = employeeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "id=" + id +
                ", skillId=" + skillId +
                ", employeeId=" + employeeId +
                '}';
    }
}
