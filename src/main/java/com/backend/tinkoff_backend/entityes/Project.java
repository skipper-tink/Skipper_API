package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
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
            referencedColumnName = "employerId", nullable = false)
    private long Employer_employerId;

    public Project(){
    }

    public Project(long projectId,
                   String projectName,
                   String projectDescription,
                   String projectStatus,
                   long Employer_employerId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectStatus = projectStatus;
        this.Employer_employerId = Employer_employerId;
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

    public long getEmployer_employerId() {
        return Employer_employerId;
    }

    public void setEmployer_employerIdr(long Employer_employerId) {
        this.Employer_employerId = Employer_employerId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", Employer_employerId=" + Employer_employerId +
                '}';
    }
}
