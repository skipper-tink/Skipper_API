package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Demand")
public class Demand {
    @Id
    @Column(name = "idDemand")
    private long idDemand;

    @JoinColumn(name = "Project_idProject",
            referencedColumnName = "idProject")
    private long idProject;

    @Column(name = "time consumption")
    private int timeConsumption;

    @Column(name = "deadline")
    private Date date;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    public Demand(){
    }

    public Demand(long idDemand,
                  long idProject,
                  int timeConsumption,
                  Date date,
                  String specialization,
                  String qualification) {
        this.idDemand = idDemand;
        this.idProject = idProject;
        this.timeConsumption = timeConsumption;
        this.date = date;
        this.specialization = specialization;
        this.qualification = qualification;
    }

    public long getIdDemand() {
        return idDemand;
    }

    public void setIdDemand(long idDemand) {
        this.idDemand = idDemand;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public int getTimeConsumption() {
        return timeConsumption;
    }

    public void setTimeConsumption(int timeConsumption) {
        this.timeConsumption = timeConsumption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                "idDemand=" + idDemand +
                ", idProject=" + idProject +
                ", timeConsumption=" + timeConsumption +
                ", date=" + date +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
