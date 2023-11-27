package com.backend.tinkoff_backend.entityes;

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
    private long Skill_skillId;

    @JoinColumn(name = "Demand_demandId",
            referencedColumnName = "demandId",
            nullable = false)
    private long Demand_demandId;

    public DemandSkill() {
    }

    public DemandSkill(long demandSkillId,
                       long skill_skillId,
                       long demand_demandId) {
        this.demandSkillId = demandSkillId;
        Skill_skillId = skill_skillId;
        Demand_demandId = demand_demandId;
    }

    public long getDemandSkillId() {
        return demandSkillId;
    }

    public void setDemandSkillId(long demandSkillId) {
        this.demandSkillId = demandSkillId;
    }

    public long getSkill_skillId() {
        return Skill_skillId;
    }

    public void setSkill_skillId(long skill_skillId) {
        Skill_skillId = skill_skillId;
    }

    public long getDemand_demandId() {
        return Demand_demandId;
    }

    public void setDemand_demandId(long demand_demandId) {
        Demand_demandId = demand_demandId;
    }

    @Override
    public String toString() {
        return "DemandSkill{" +
                "demandSkillId=" + demandSkillId +
                ", Skill_skillId=" + Skill_skillId +
                ", Demand_demandId=" + Demand_demandId +
                '}';
    }
}
