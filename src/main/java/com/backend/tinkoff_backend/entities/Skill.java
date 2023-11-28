package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Skill")
public class Skill {

    @Id
    @Column(name = "skillId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long skillId;

    @Column(name = "skillName", nullable = false)
    private String skillName;

    public Skill() {
    }

    public Skill(long skillId,
                 String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                '}';
    }
}
