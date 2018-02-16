package com.sahanruwanga.medcarer;

/**
 * Created by Sahan Ruwanga on 2/6/2018.
 */

public class MedicalRecord {
    private String disease;
    private String medicine;
    private String allergic;
    private String date;
    private String doctor;
    private String contact;
    private String description;

//    public MedicalRecord(String disease, String medicine,String allergic, String date, String doctor, String contact, String description) {
//        this.setMedicine(medicine);
//        this.setDisease(disease);
//        this.setDoctor(doctor);
//        this.setContact(contact);
//        this.setDate(date);
//        this.setDescription(description);
//        this.setAllergic(allergic);
//    }
    public MedicalRecord(String disease, String medicine, String allergic, String date){
        this.disease=disease;
        this.medicine=medicine;
        this.allergic=allergic;
        this.date=date;
    }

    public MedicalRecord(){}


    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getAllergic() {
        return allergic;
    }

    public void setAllergic(String allergic) {
        this.allergic = allergic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

