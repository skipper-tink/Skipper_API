package com.backend.tinkoff_backend.controllers.demandEmployee;



public class DemandAndEmployeeIdPojo {
    private long demandId;
    private long employeeId;

    public DemandAndEmployeeIdPojo() {}

    public DemandAndEmployeeIdPojo(long demandId, long employeeId) {
        this.demandId = demandId;
        this.employeeId = employeeId;
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
}
