package com.example.micitaquileia.entities;

public class Doctor {
    private int id;
    private String fullName;
    private String professionalCardCode;
    private String speciality;
    private float yearsOfExperience;
    private String office;
    private boolean servesAtHome;

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfessionalCardCode() {
        return professionalCardCode;
    }

    public void setProfessionalCardCode(String professionalCardCode) {
        this.professionalCardCode = professionalCardCode;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public boolean isServesAtHome() {
        return servesAtHome;
    }

    public void setServesAtHome(boolean servesAtHome) {
        this.servesAtHome = servesAtHome;
    }
}
