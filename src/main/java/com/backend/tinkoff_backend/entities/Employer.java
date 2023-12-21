package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @Column(name = "employerId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employerId;

    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private long userId;

    public Employer(){
    }

    public Employer( long userId) {
        this.userId = userId;
    }

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long employerId) {
        this.employerId = employerId;
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
                "employerId=" + employerId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
