package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private String status;

    @JoinColumn(name = "employer_id",
            referencedColumnName = "id",
            nullable = false)
    private long employerId;

    public Project(){
    }

    public Project(String projectName,
                   String description,
                   String projectStatus,
                   long Employer_employerId) {
        this.name = projectName;
        this.description = description;
        this.status = projectStatus;
        this.employerId = Employer_employerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long projectId) {
        this.id = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String projectName) {
        this.name = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String projectDescription) {
        this.description = projectDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String projectStatus) {
        this.status = projectStatus;
    }

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long Employer_employerId) {
        this.employerId = Employer_employerId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + id +
                ", projectName='" + name + '\'' +
                ", projectDescription='" + description + '\'' +
                ", projectStatus='" + status + '\'' +
                ", employerId=" + employerId +
                '}';
    }
}
