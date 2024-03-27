package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "SprDemand")
public class Demand {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "sprProjectId",
            referencedColumnName = "id", nullable = false)
    private long projectId;

    @Column(name = "timeConsumption", nullable = false)
    private int timeConsumption;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    public Demand() {
    }

    public Demand(long projectId,
                  int timeConsumption,
                  Date deadline,
                  String specialization,
                  String qualification) {
        this.projectId = projectId;
        this.timeConsumption = timeConsumption;
        this.deadline = deadline;
        this.specialization = specialization;
        this.qualification = qualification;
    }

    public long getId() {
        return id;
    }

    public void setId(long demandId) {
        this.id = demandId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getTimeConsumption() {
        return timeConsumption;
    }

    public void setTimeConsumption(int timeConsumption) {
        this.timeConsumption = timeConsumption;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", timeConsumption=" + timeConsumption +
                ", deadline=" + deadline +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
