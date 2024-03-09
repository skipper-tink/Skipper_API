package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "demand_skill")
public class DemandSkill {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "skill_id",
            referencedColumnName = "id",
            nullable = false)
    private long skillId;

    @JoinColumn(name = "demand_id",
            referencedColumnName = "id",
            nullable = false)
    private long demandId;

    public DemandSkill() {
    }

    public DemandSkill(long skillId,
                       long demandId) {
        this.skillId = skillId;
        this.demandId = demandId;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    @Override
    public String toString() {
        return "DemandSkill{" +
                "id=" + id +
                ", skillId=" + skillId +
                ", demandId=" + demandId +
                '}';
    }
}
