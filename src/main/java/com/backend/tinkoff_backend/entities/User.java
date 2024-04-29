package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "spr_user")
public class User {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @JoinColumn(name = "employer_id", referencedColumnName = "id",unique = true)
    private long employer_id;

    @JoinColumn(name = "employee_id", referencedColumnName = "id",unique = true)
    private long employee_id;

    public User(){}

    public User(String login, String password, long employer_id, long employee_id) {
        this.login = login;
        this.password = password;
        this.employer_id = employer_id;
        this.employee_id = employee_id;
    }

    public User(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.employer_id = user.getEmployer_id();
        this.employee_id = user.getEmployee_id();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(long employer_id) {
        this.employer_id = employer_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", employer_id=" + employer_id +
                ", employee_id=" + employee_id +
                '}';
    }
}
