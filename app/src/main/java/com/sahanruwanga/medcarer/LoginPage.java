package com.sahanruwanga.medcarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private AutoCompleteTextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.passwordTxt);

    }

    public void userLogin(View view) {
        if(!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
            new User(this).login(username.getText().toString(), password.getText().toString());
        }else{
            Toast.makeText(this,"Please enter username and password!",Toast.LENGTH_LONG).show();
        }
    }

    public void openRegisterPage(View view){
        Intent intent = new Intent(this,EmailRegister.class);
        startActivity(intent);
        finish();
    }

}
