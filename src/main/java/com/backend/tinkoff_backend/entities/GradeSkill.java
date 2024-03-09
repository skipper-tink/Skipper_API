package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grade_skill")
public class GradeSkill {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public GradeSkill(long skillId,
                      long gradeId) {
        this.skillId = skillId;
        this.gradeId = gradeId;
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

    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "GradeSkill{" +
                "id=" + id +
                ", skillId=" + skillId +
                ", gradeId=" + gradeId +
                '}';
    }
}
