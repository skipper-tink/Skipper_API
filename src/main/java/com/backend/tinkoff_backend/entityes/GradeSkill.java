package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "GradeSkill")
public class GradeSkill {

    @Id
    @Column(name = "gradeSkillId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradeSkillId;

    @JoinColumn(name = "Skill_skillId",
            referencedColumnName = "skillId", nullable = false)
    private long Skill_skillId;

    @JoinColumn(name = "EmployeeGrade_employeeGradeId",
            referencedColumnName = "employeeGradeId", nullable = false)
    private long EmployeeGrade_employeeGradeId;

    public GradeSkill() {
    }

    public GradeSkill(long gradeSkillId,
                      long skill_skillId,
                      long employeeGrade_employeeGradeId) {
        this.gradeSkillId = gradeSkillId;
        Skill_skillId = skill_skillId;
        EmployeeGrade_employeeGradeId = employeeGrade_employeeGradeId;
    }

    public long getGradeSkillId() {
        return gradeSkillId;
    }

    public void setGradeSkillId(long gradeSkillId) {
        this.gradeSkillId = gradeSkillId;
    }

    public long getSkill_skillId() {
        return Skill_skillId;
    }

    public void setSkill_skillId(long skill_skillId) {
        Skill_skillId = skill_skillId;
    }

    public long getEmployeeGrade_employeeGradeId() {
        return EmployeeGrade_employeeGradeId;
    }

    public void setEmployeeGrade_employeeGradeId(long employeeGrade_employeeGradeId) {
        EmployeeGrade_employeeGradeId = employeeGrade_employeeGradeId;
    }

    @Override
    public String toString() {
        return "GradeSkill{" +
                "gradeSkillId=" + gradeSkillId +
                ", Skill_skillId=" + Skill_skillId +
                ", EmployeeGrade_employeeGradeId=" + EmployeeGrade_employeeGradeId +
                '}';
    }
}
