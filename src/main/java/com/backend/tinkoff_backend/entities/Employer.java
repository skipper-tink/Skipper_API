package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @Column(name = "employerId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employerId;

    @JoinColumn(name = "User_userLogin",
            referencedColumnName = "userLogin",
            nullable = false)
    private String userLogin;

    public Employer(){
    }

    public Employer( String User_userLogin) {
        this.userLogin = User_userLogin;
    }

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long employerId) {
        this.employerId = employerId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String User_userLogin) {
        this.userLogin = User_userLogin;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}
