package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SprEmployer")
public class Employer {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "sprUserId",
            referencedColumnName = "id",
            nullable = false)
    private long userId;

    public Employer(){
    }

    public Employer( long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                '}';
    }
}
