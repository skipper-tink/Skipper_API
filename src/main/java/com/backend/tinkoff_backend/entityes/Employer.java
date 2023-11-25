package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @Column(name = "idEmployer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEmployer;

    @JoinColumn(name = "user_login", referencedColumnName = "login")
    private String userLogin;

    public Employer(){
    }

    public Employer(long idEmployer, String userLogin) {
        this.idEmployer = idEmployer;
        this.userLogin = userLogin;
    }

    public long getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(long idEmployer) {
        this.idEmployer = idEmployer;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "idEmployer=" + idEmployer +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}
