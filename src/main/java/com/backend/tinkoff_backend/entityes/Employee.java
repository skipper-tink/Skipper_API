package com.backend.tinkoff_backend.entityes;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "employeeId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @JoinColumn(name = "User_userLogin", referencedColumnName = "userLogin", nullable = false)
    private String User_userLogin;

    @Column(name = "employeeFreeTimePerWeek")
    private long employeeFreeTimePerWeek;

    @Column(name = "employeeThisFreeTimeUntilDate")
    private Date employeeThisFreeTimeUntilDate;

    public Employee(){
    }

    public Employee(long employeeId,
                    String User_userLogin,
                    long employeeFreeTimePerWeek,
                    Date employeeThisFreeTimeUntilDate) {
        this.employeeId = employeeId;
        this.User_userLogin = User_userLogin;
        this.employeeFreeTimePerWeek = employeeFreeTimePerWeek;
        this.employeeThisFreeTimeUntilDate = employeeThisFreeTimeUntilDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getUser_userLogin() {
        return User_userLogin;
    }

    public void setUser_userLogin(String User_userLogin) {
        this.User_userLogin = User_userLogin;
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
                ", User_userLogin='" + User_userLogin + '\'' +
                ", employeeFreeTimePerWeek=" + employeeFreeTimePerWeek +
                ", employeeThisFreeTimeUntilDate=" + employeeThisFreeTimeUntilDate +
                '}';
    }
}
