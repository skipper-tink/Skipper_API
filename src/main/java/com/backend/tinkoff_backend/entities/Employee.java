package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "employeeId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @JoinColumn(name = "User_userLogin",
            referencedColumnName = "userLogin",
            nullable = false)
    private String userLogin;

    @Column(name = "employeeFreeTimePerWeek")
    private long employeeFreeTimePerWeek;

    @Column(name = "employeeThisFreeTimeUntilDate")
    private Date employeeThisFreeTimeUntilDate;

    public Employee(){
    }

    public Employee(String User_userLogin,
                    long employeeFreeTimePerWeek,
                    Date employeeThisFreeTimeUntilDate) {
        this.userLogin = User_userLogin;
        this.employeeFreeTimePerWeek = employeeFreeTimePerWeek;
        this.employeeThisFreeTimeUntilDate = employeeThisFreeTimeUntilDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String User_userLogin) {
        this.userLogin = User_userLogin;
    }

    public long getEmployeeFreeTimePerWeek() {
        return employeeFreeTimePerWeek;
    }

    public void setEmployeeFreeTimePerWeek(long employeeFreeTimePerWeek) {
        this.employeeFreeTimePerWeek = employeeFreeTimePerWeek;
    }

    public Date getEmployeeThisFreeTimeUntilDate() {
        return employeeThisFreeTimeUntilDate;
    }

    public void setEmployeeThisFreeTimeUntilDate(Date employeeThisFreeTimeUntilDate) {
        this.employeeThisFreeTimeUntilDate = employeeThisFreeTimeUntilDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", userLogin='" + userLogin + '\'' +
                ", employeeFreeTimePerWeek=" + employeeFreeTimePerWeek +
                ", employeeThisFreeTimeUntilDate=" + employeeThisFreeTimeUntilDate +
                '}';
    }
}
