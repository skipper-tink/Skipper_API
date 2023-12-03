package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @Column(name = "projectId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Column(name = "projectDescription", nullable = false)
    private String projectDescription;

    @Column(name = "projectStatus", nullable = false)
    private String projectStatus;

    @JoinColumn(name = "Employer_employerId",
            referencedColumnName = "employerId",
            nullable = false)
    private long employerId;

    public Project(){
    }

    public Project(String projectName,
                   String projectDescription,
                   String projectStatus,
                   long Employer_employerId) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
        this.employerId = Employer_employerId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerIdr(long Employer_employerId) {
        this.employerId = Employer_employerId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", employerId=" + employerId +
                '}';
    }
}
