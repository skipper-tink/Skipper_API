package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "demand_employee")
public class DemandEmployee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "demand_id",
            referencedColumnName = "id",
            nullable = false)
    private long demandId;

    @JoinColumn(name = "employee_id",
            referencedColumnName = "id",
            nullable = false)
    private long employeeId;

    public DemandEmployee() {
    }

    public DemandEmployee(long demandId,
                          long employeeId) {
        this.demandId = demandId;
        this.employeeId = employeeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demandId) {
        this.demandId = demandId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "DemandEmployee{" +
                "id=" + id +
                ", demandId=" + demandId +
                ", employeeId=" + employeeId +
                '}';
    }
}
