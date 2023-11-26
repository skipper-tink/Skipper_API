package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @Column(name = "idEmployer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEmployer;

    @JoinColumn(name = "user_login",
            referencedColumnName = "userLogin")
    private String user_login;

    public Employer(){
    }

    public Employer(long idEmployer, String userLogin) {
        this.idEmployer = idEmployer;
        this.user_login = userLogin;
    }

    public long getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(long idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "idEmployer=" + idEmployer +
                ", user_login='" + user_login + '\'' +
                '}';
    }
}
