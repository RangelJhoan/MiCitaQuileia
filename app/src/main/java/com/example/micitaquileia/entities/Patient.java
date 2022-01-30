package com.example.micitaquileia.entities;

public class Patient {
    private int id;
    private String identificationCard;
    private String name;
    private String surname;
    private String birthDate;
    private boolean isInTreatment;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isInTreatment() {
        return isInTreatment;
    }

    public void setInTreatment(boolean inTreatment) {
        isInTreatment = inTreatment;
    }
}
