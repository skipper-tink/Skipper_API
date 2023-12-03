package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DemandSkill")
public class DemandSkill {

    @Id
    @Column(name = "demandSkillId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long demandSkillId;

    @JoinColumn(name = "Skill_skillId",
            referencedColumnName = "skillId",
            nullable = false)
    private long skillId;

    @JoinColumn(name = "Demand_demandId",
            referencedColumnName = "demandId",
            nullable = false)
    private long demandId;

    public DemandSkill() {
    }

    public DemandSkill(long skill_skillId,
                       long demand_demandId) {
        skillId = skill_skillId;
        demandId = demand_demandId;
    }

    public long getDemandSkillId() {
        return demandSkillId;
    }

    public void setDemandSkillId(long demandSkillId) {
        this.demandSkillId = demandSkillId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skill_skillId) {
        skillId = skill_skillId;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demand_demandId) {
        demandId = demand_demandId;
    }

    @Override
    public String toString() {
        return "DemandSkill{" +
                "demandSkillId=" + demandSkillId +
                ", skillId=" + skillId +
                ", demandId=" + demandId +
                '}';
    }
}
