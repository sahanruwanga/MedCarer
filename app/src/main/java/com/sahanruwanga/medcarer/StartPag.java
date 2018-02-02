package com.sahanruwanga.medcarer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPag extends AppCompatActivity {
    private Button emailBtn, phoneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_pag);

        emailBtn = (Button) findViewById(R.id.emailBtn);
        phoneBtn = (Button) findViewById(R.id.phoneBtn);
    }

    public void openEmailLogin(View view){
        Intent intent = new Intent(this,EmailLogin.class);
        startActivity(intent);

    }

    public void openPhoneLogin(View view){
        Intent intent = new Intent(this,PhoneLogin.class);
        startActivity(intent);
    }
}
