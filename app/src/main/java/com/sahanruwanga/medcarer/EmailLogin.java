package com.sahanruwanga.medcarer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class EmailLogin extends AppCompatActivity {
    private AutoCompleteTextView email, password, conPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);

        email = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passwordTxt);
        conPassword = findViewById(R.id.conPassTxt);
    }

    public void createNewUser(View view){
        if(conPassword.getText().toString().equals(password.getText().toString())) {
            new User(email.getText().toString(), password.getText().toString());
            Toast.makeText(this, "Correct password confirmation!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Incorrect password confirmation!",Toast.LENGTH_LONG).show();
            conPassword.setText("");
        }
    }
}
