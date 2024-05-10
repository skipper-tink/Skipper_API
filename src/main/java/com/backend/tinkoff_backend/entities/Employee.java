package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "spr_employee")
public class Employee {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "free_time_per_week")
    private long freeTimePerWeek;

    @Column(name = "free_time_until_date")
    private Date freeTimeUntilDate;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "rating")
    private double rating;

    @Column(name = "feedbacks_count")
    private int feedbacksCount;

    public Employee(){
    }

    public Employee(String name, long freeTimePerWeek, Date freeTimeUntilDate, String specialization, String qualification, String email, String phoneNumber, String description, double rating, int feedbacksCount) {
        this.name = name;
        this.freeTimePerWeek = freeTimePerWeek;
        this.freeTimeUntilDate = freeTimeUntilDate;
        this.specialization = specialization;
        this.qualification = qualification;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.rating = rating;
        this.feedbacksCount = feedbacksCount;
    }

    public Employee(Employee employee) {
        this.name = employee.getName();
        this.freeTimePerWeek = employee.getFreeTimePerWeek();
        this.freeTimeUntilDate = employee.getFreeTimeUntilDate();
        this.specialization = employee.getSpecialization();
        this.qualification = employee.getQualification();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.description = employee.getDescription();
        this.rating = employee.getRating();
        this.feedbacksCount = employee.getFeedbacksCount();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFreeTimePerWeek() {
        return freeTimePerWeek;
    }

    public void setFreeTimePerWeek(long freeTimePerWeek) {
        this.freeTimePerWeek = freeTimePerWeek;
    }

    public Date getFreeTimeUntilDate() {
        return freeTimeUntilDate;
    }

    public void setFreeTimeUntilDate(Date freeTimeUntilDate) {
        this.freeTimeUntilDate = freeTimeUntilDate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getFeedbacksCount() {
        return feedbacksCount;
    }

    public void setFeedbacksCount(int feedbacksCount) {
        this.feedbacksCount = feedbacksCount;
    }
}
