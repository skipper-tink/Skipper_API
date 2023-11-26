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

    @Column(name = "freeTimePerWeek")
    private long freeTimePerWeek;

    @Column(name = "thisFreeTimeUntilDate")
    private Date thisFreeTimeUntilDate;

    public Employee(){
    }

    public Employee(long employeeId,
                    String User_userLogin,
                    long freeTimePerWeek,
                    Date thisFreeTimeUntilDate) {
        this.employeeId = employeeId;
        this.User_userLogin = User_userLogin;
        this.freeTimePerWeek = freeTimePerWeek;
        this.thisFreeTimeUntilDate = thisFreeTimeUntilDate;
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
                "employeeId=" + employeeId +
                ", User_userLogin='" + User_userLogin + '\'' +
                ", freeTimePerWeek=" + freeTimePerWeek +
                ", thisFreeTimeUntilDate=" + thisFreeTimeUntilDate +
                '}';
    }
}
