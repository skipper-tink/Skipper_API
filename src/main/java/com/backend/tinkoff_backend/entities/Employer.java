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
    private String User_userLogin;

    public Employer(){
    }

    public Employer(long employerId, String User_userLogin) {
        this.employerId = employerId;
        this.User_userLogin = User_userLogin;
    }

    public long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(long employerId) {
        this.employerId = employerId;
    }

    public String getUser_userLogin() {
        return User_userLogin;
    }

    public void setUser_userLogin(String User_userLogin) {
        this.User_userLogin = User_userLogin;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", User_userLogin='" + User_userLogin + '\'' +
                '}';
    }
}
