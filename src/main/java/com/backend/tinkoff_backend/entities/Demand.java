package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long demandId;

    @JoinColumn(name = "project_id",
            referencedColumnName = "id", nullable = false)
    private long projectId;

    @Column(name = "time_consumption", nullable = false)
    private int demandTimeConsumption;

    @Column(name = "deadline", nullable = false)
    private Date demandDeadline;

    @Column(name = "specialization")
    private String demandSpecialization;

    @Column(name = "qualification")
    private String demandQualification;

    public Demand() {
    }

    public Demand(long Project_projectId,
                  int demandTimeConsumption,
                  Date demandDeadline,
                  String demandSpecialization,
                  String demandQualification) {
        this.projectId = Project_projectId;
        this.demandTimeConsumption = demandTimeConsumption;
        this.demandDeadline = demandDeadline;
        this.demandSpecialization = demandSpecialization;
        this.demandQualification = demandQualification;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long Project_projectId) {
        this.projectId = Project_projectId;
    }

    public int getDemandTimeConsumption() {
        return demandTimeConsumption;
    }

    public void setDemandTimeConsumption(int demandTimeConsumption) {
        this.demandTimeConsumption = demandTimeConsumption;
    }

    public Date getDemandDeadline() {
        return demandDeadline;
    }

    public void setDemandDeadline(Date demandDeadline) {
        this.demandDeadline = demandDeadline;
    }

    public String getDemandSpecialization() {
        return demandSpecialization;
    }

    public void setDemandSpecialization(String demandSpecialization) {
        this.demandSpecialization = demandSpecialization;
    }

    public String getDemandQualification() {
        return demandQualification;
    }

    public void setDemandQualification(String demandQualification) {
        this.demandQualification = demandQualification;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "demandId=" + demandId +
                ", projectId=" + projectId +
                ", demandTimeConsumption=" + demandTimeConsumption +
                ", demandDeadline=" + demandDeadline +
                ", demandSpecialization='" + demandSpecialization + '\'' +
                ", demandQualification='" + demandQualification + '\'' +
                '}';
    }
}
