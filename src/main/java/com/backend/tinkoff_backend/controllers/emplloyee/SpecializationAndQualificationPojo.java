package com.backend.tinkoff_backend.controllers.emplloyee;

public class SpecializationAndQualificationPojo {
    private String specialization;
    private String qualification;

    public SpecializationAndQualificationPojo() {}

    public SpecializationAndQualificationPojo(String specialization, String qualification) {
        this.specialization = specialization;
        this.qualification = qualification;
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
}
