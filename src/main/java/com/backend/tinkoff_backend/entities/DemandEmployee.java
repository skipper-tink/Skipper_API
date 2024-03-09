package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "demand_employee")
public class DemandEmployee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInvolvedEmployee;

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

    public DemandEmployee(long demand_demandId,
                          long employee_employeeId) {
        demandId = demand_demandId;
        employeeId = employee_employeeId;
    }

    public long getIdInvolvedEmployee() {
        return idInvolvedEmployee;
    }

    public void setIdInvolvedEmployee(long idInvolvedEmployee) {
        this.idInvolvedEmployee = idInvolvedEmployee;
    }

    public long getDemandId() {
        return demandId;
    }

    public void setDemandId(long demand_demandId) {
        demandId = demand_demandId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employee_employeeId) {
        employeeId = employee_employeeId;
    }

    @Override
    public String toString() {
        return "DemandEmployee{" +
                "idInvolvedEmployee=" + idInvolvedEmployee +
                ", demandId=" + demandId +
                ", employeeId=" + employeeId +
                '}';
    }
}
