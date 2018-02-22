package com.sahanruwanga.medcarer.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sahanruwanga.medcarer.R;
import com.sahanruwanga.medcarer.controllers.User;

public class EmailRegister extends AppCompatActivity {
    private AutoCompleteTextView username;
    private AutoCompleteTextView password;
    private AutoCompleteTextView conPassword;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        setUsername((AutoCompleteTextView)findViewById(R.id.emailTxt));
        setPassword((AutoCompleteTextView) findViewById(R.id.passwordTxt));
        setConPassword((AutoCompleteTextView) findViewById(R.id.conPassTxt));
    }

    public void registerUser(View view){
        if(!getUsername().getText().toString().trim().equals("") && !getPassword().getText().toString().trim().equals("")
                && !getConPassword().getText().toString().trim().equals("")) {
            if (getConPassword().getText().toString().trim().equals(getPassword().getText().toString().trim())) {
                User user = new User(getUsername().getText().toString().trim(), getPassword().getText().toString().trim());
                user.register( this);
            } else {
                Toast.makeText(this, "Incorrect password confirmation!", Toast.LENGTH_LONG).show();
                getConPassword().setText("");
            }
        }
    }

    public void openLogin(View view){
        Intent intent = new Intent(this,LoginPage.class);
        startActivity(intent);
        finish();
    }

    //region Getters and Setters
    public AutoCompleteTextView getUsername() {
        return username;
    }

    public void setUsername(AutoCompleteTextView username) {
        this.username = username;
    }

    public AutoCompleteTextView getPassword() {
        return password;
    }

    public void setPassword(AutoCompleteTextView password) {
        this.password = password;
    }

    public AutoCompleteTextView getConPassword() {
        return conPassword;
    }

    public void setConPassword(AutoCompleteTextView conPassword) {
        this.conPassword = conPassword;
    }
    //endregion
}
