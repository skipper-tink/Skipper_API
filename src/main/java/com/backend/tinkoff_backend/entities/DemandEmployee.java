package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DemandEmployee")
public class DemandEmployee {

    @Id
    @Column(name = "demandEmployeeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInvolvedEmployee;

    @JoinColumn(name = "Demand_demandId",
            referencedColumnName = "demandId",
            nullable = false)
    private long Demand_demandId;

    @JoinColumn(name = "Employee_employeeId",
            referencedColumnName = "employeeId",
            nullable = false)
    private long Employee_employeeId;

    public DemandEmployee() {
    }

    public DemandEmployee(long demand_demandId,
                          long employee_employeeId) {
        Demand_demandId = demand_demandId;
        Employee_employeeId = employee_employeeId;
    }

    public long getIdInvolvedEmployee() {
        return idInvolvedEmployee;
    }

    public void setIdInvolvedEmployee(long idInvolvedEmployee) {
        this.idInvolvedEmployee = idInvolvedEmployee;
    }

    public long getDemand_demandId() {
        return Demand_demandId;
    }

    public void setDemand_demandId(long demand_demandId) {
        Demand_demandId = demand_demandId;
    }

    public long getEmployee_employeeId() {
        return Employee_employeeId;
    }

    public void setEmployee_employeeId(long employee_employeeId) {
        Employee_employeeId = employee_employeeId;
    }

    @Override
    public String toString() {
        return "DemandEmployee{" +
                "idInvolvedEmployee=" + idInvolvedEmployee +
                ", Demand_demandId=" + Demand_demandId +
                ", Employee_employeeId=" + Employee_employeeId +
                '}';
    }
}
