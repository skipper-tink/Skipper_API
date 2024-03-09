package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grade_skill")
public class GradeSkill {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradeSkillId;

    @JoinColumn(name = "skill_id",
            referencedColumnName = "id",
            nullable = false)
    private long skillId;

    @JoinColumn(name = "grade_id",
            referencedColumnName = "id",
            nullable = false)
    private long gradeId;

    public GradeSkill() {
    }

    public GradeSkill(long skill_skillId,
                      long Grade_gradeId) {
        skillId = skill_skillId;
        gradeId = Grade_gradeId;
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

    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long Grade_gradeId) {
        gradeId = Grade_gradeId;
    }

    @Override
    public String toString() {
        return "GradeSkill{" +
                "gradeSkillId=" + gradeSkillId +
                ", skillId=" + skillId +
                ", gradeId=" + gradeId +
                '}';
    }
}
