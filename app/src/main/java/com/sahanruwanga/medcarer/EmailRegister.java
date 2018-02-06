package com.sahanruwanga.medcarer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class EmailRegister extends AppCompatActivity {
    private AutoCompleteTextView username, password, conPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        username = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passwordTxt);
        conPassword = findViewById(R.id.conPassTxt);
    }

    public void createNewUser(View view){
        if(!username.getText().toString().equals("") && !password.getText().toString().equals("")
                && !conPassword.getText().toString().equals("")) {
            if (conPassword.getText().toString().equals(password.getText().toString())) {
                new User(username.getText().toString(), password.getText().toString(), this);
            } else {
                Toast.makeText(this, "Incorrect password confirmation!", Toast.LENGTH_LONG).show();
                conPassword.setText("");
            }
        }
    }
}
