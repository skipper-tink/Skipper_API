package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "GradeSkill")
public class GradeSkill {

    @Id
    @Column(name = "gradeSkillId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradeSkillId;

    @JoinColumn(name = "Skill_skillId",
            referencedColumnName = "skillId",
            nullable = false)
    private long skillId;

    @JoinColumn(name = "EmployeeGrade_employeeGradeId",
            referencedColumnName = "employeeGradeId",
            nullable = false)
    private long employeeGradeId;

    public GradeSkill() {
    }

    public GradeSkill(long skill_skillId,
                      long employeeGrade_employeeGradeId) {
        skillId = skill_skillId;
        employeeGradeId = employeeGrade_employeeGradeId;
    }

    public long getGradeSkillId() {
        return gradeSkillId;
    }

    public void setGradeSkillId(long gradeSkillId) {
        this.gradeSkillId = gradeSkillId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skill_skillId) {
        skillId = skill_skillId;
    }

    public long getEmployeeGradeId() {
        return employeeGradeId;
    }

    public void setEmployeeGradeId(long employeeGrade_employeeGradeId) {
        employeeGradeId = employeeGrade_employeeGradeId;
    }

    @Override
    public String toString() {
        return "GradeSkill{" +
                "gradeSkillId=" + gradeSkillId +
                ", skillId=" + skillId +
                ", employeeGradeId=" + employeeGradeId +
                '}';
    }
}
