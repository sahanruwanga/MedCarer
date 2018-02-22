package com.sahanruwanga.medcarer.controllers;


import android.app.Activity;
import android.util.Log;

import com.sahanruwanga.medcarer.model.Model;

/**
 * Created by Sahan Ruwanga on 2/2/2018.
 */

public class User {
    private String email;
    private String password;
    private Activity activity;
    private Model model;

    public User(String email, String password){  //Default constructor
        this.setEmail(email);
        this.setPassword(password);
    }


    public User getUser(){
        return this;
    }
    public User(Activity activity){    //Constructor for logging out a user
        this.setActivity(activity);
        this.setModel(new Model());
    }

    public void register( Activity activity){
        this.setModel(new Model());
        this.getModel().userRegistration(this, activity);
        this.updateProfile();
    }

    public void login(Activity activity){        //User userLogin call for model
        this.getModel().userLogin(this, activity);
    }

    public void logout(){                                   //User userLogout call for model
        this.getModel().userLogout(getActivity());
    }

    public void saveMedicalRecord(MedicalRecord medicalRecord){       //Call for saving medical record to model
//        this.getModel().getDatabaseReference().child("users").child(getModel().getCurrentUser().getUid());
//        this.getModel().getDatabaseReference().child("users").child(getModel().getCurrentUser().getUid()).child("medication_history")
//                .setValue(medicalRecord);
        this.getModel().saveMedicalRecord(medicalRecord);
    }

    public void updateProfile(){
        this.getModel().getDatabaseReference().child("users").child("sahan")
                .child("userProfile").setValue(new MedicalRecord("s","s","s","s","S","S","s"));
    }

    //region Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    //endregion
}
