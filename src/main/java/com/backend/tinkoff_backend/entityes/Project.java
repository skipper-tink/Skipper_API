package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "idProject")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @JoinColumn(name = "Employer_IdEmployer",
            referencedColumnName = "idEmployer")
    private long idEmployer;

    public Project(){
    }

    public Project(long id,
                   String name,
                   String description,
                   String status,
                   long idEmployer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.idEmployer = idEmployer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(long idEmployer) {
        this.idEmployer = idEmployer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", idEmployer=" + idEmployer +
                '}';
    }
}
