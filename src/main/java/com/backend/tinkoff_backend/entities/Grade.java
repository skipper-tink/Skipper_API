package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Grade")
public class Grade {

    @Id
    @Column(name = "gradeId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gradeId;

    @JoinColumn(name = "Employee_employeeId",
            referencedColumnName = "employeeId",
            nullable = false)
    private long employeeId;

    @Column(name = "gradeSpecialization", nullable = false)
    private String gradeSpecialization;

    @Column(name = "gradeQualification", nullable = false)
    private String gradeQualification;

    public Grade() {
    }

    public Grade(long employee_employeeId,
                 String gradeSpecialization,
                 String gradeQualification) {
        employeeId = employee_employeeId;
        this.gradeSpecialization = gradeSpecialization;
        this.gradeQualification = gradeQualification;
    }

    public long getGradeId() {
        return gradeId;
    }

    public void setGradeId(long gradeId) {
        this.gradeId = gradeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employee_employeeId) {
        employeeId = employee_employeeId;
    }

    public String getGradeSpecialization() {
        return gradeSpecialization;
    }

    public void setGradeSpecialization(String gradeSpecialization) {
        this.gradeSpecialization = gradeSpecialization;
    }

    public String getGradeQualification() {
        return gradeQualification;
    }

    public void setGradeQualification(String gradeQualification) {
        this.gradeQualification = gradeQualification;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", employeeId=" + employeeId +
                ", gradeSpecialization='" + gradeSpecialization + '\'' +
                ", gradeQualification='" + gradeQualification + '\'' +
                '}';
    }
}