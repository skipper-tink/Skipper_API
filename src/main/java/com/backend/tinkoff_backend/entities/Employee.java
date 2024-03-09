package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private long userId;

    @Column(name = "free_time_per_week")
    private long employeeFreeTimePerWeek;

    @Column(name = "free_time_until_date")
    private Date employeeThisFreeTimeUntilDate;

    public Employee(){
    }

    public Employee(long userId,
                    long employeeFreeTimePerWeek,
                    Date employeeThisFreeTimeUntilDate) {
        this.userId = userId;
        this.employeeFreeTimePerWeek = employeeFreeTimePerWeek;
        this.employeeThisFreeTimeUntilDate = employeeThisFreeTimeUntilDate;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
                ", userId='" + userId + '\'' +
                ", employeeFreeTimePerWeek=" + employeeFreeTimePerWeek +
                ", employeeThisFreeTimeUntilDate=" + employeeThisFreeTimeUntilDate +
                '}';
    }
}
