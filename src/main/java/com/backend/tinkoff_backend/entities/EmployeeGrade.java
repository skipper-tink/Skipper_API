package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EmployeeGrade")
public class EmployeeGrade {

    @Id
    @Column(name = "employeeGradeId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeGradeId;

    @JoinColumn(name = "Employee_employeeId",
            referencedColumnName = "employeeId",
            nullable = false)
    private long Employee_employeeId;

    @Column(name = "employeeGradeSpecialization", nullable = false)
    private String employeeGradeSpecialization;

    @Column(name = "employeeGradeQualification", nullable = false)
    private String employeeGradeQualification;

    public EmployeeGrade() {
    }

    public EmployeeGrade(long employee_employeeId,
                         String employeeGradeSpecialization,
                         String employeeGradeQualification) {
        Employee_employeeId = employee_employeeId;
        this.employeeGradeSpecialization = employeeGradeSpecialization;
        this.employeeGradeQualification = employeeGradeQualification;
    }

    public long getEmployeeGradeId() {
        return employeeGradeId;
    }

    public void setEmployeeGradeId(long employeeGradeId) {
        this.employeeGradeId = employeeGradeId;
    }

    public long getEmployee_employeeId() {
        return Employee_employeeId;
    }

    public void setEmployee_employeeId(long employee_employeeId) {
        Employee_employeeId = employee_employeeId;
    }

    public String getEmployeeGradeSpecialization() {
        return employeeGradeSpecialization;
    }

    public void setEmployeeGradeSpecialization(String employeeGradeSpecialization) {
        this.employeeGradeSpecialization = employeeGradeSpecialization;
    }

    public String getEmployeeGradeQualification() {
        return employeeGradeQualification;
    }

    public void setEmployeeGradeQualification(String employeeGradeQualification) {
        this.employeeGradeQualification = employeeGradeQualification;
    }
}
