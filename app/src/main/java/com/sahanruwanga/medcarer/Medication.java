package com.sahanruwanga.medcarer;

/**
 * Created by Sahan Ruwanga on 2/6/2018.
 */

public class Medication {
    public String medicineName;
    public String disease;
    public String doctor;
    public String contact;
    public String date;
    public String description;

    public Medication(String medicineName, String disease, String doctor, String contact, String date, String description) {
        this.medicineName = medicineName;
        this.disease = disease;
        this.doctor = doctor;
        this.contact = contact;
        this.date = date;
        this.description = description;
    }

    public Medication(){

    }
}
