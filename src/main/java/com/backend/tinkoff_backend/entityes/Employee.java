package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "idEmployee")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEmployee;

    @JoinColumn(name = "user_login", referencedColumnName = "userLogin")
    private String user_login;

    @Column(name = "freeTimePerWeek")
    private long freeTimePerWeek;

    @Column(name = "thisFreeTimeUntilDate")
    private Date thisFreeTimeUntilDate;

    public Employee(){
    }

    public Employee(long idEmployee,
                    String userLogin,
                    long freeTimePerWeek,
                    Date thisFreeTimeUntilDate) {
        this.idEmployee = idEmployee;
        this.user_login = userLogin;
        this.freeTimePerWeek = freeTimePerWeek;
        this.thisFreeTimeUntilDate = thisFreeTimeUntilDate;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public long getFreeTimePerWeek() {
        return freeTimePerWeek;
    }

    public void setFreeTimePerWeek(long freeTimePerWeek) {
        this.freeTimePerWeek = freeTimePerWeek;
    }

    public Date getThisFreeTimeUntilDate() {
        return thisFreeTimeUntilDate;
    }

    public void setThisFreeTimeUntilDate(Date thisFreeTimeUntilDate) {
        this.thisFreeTimeUntilDate = thisFreeTimeUntilDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", userLogin='" + user_login + '\'' +
                ", freeTimePerWeek=" + freeTimePerWeek +
                ", thisFreeTimeUntilDate=" + thisFreeTimeUntilDate +
                '}';
    }
}
