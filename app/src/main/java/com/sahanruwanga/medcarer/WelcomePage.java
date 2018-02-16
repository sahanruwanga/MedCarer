package com.sahanruwanga.medcarer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomePage extends AppCompatActivity {
    private static int opening_delay = 2000;
    public User user;

    @Override
    protected void onStart() {
        super.onStart();
        user = new User(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user.checkCurrentUser()!=null){
                    Intent intent = new Intent(WelcomePage.this,Home.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(WelcomePage.this, LoginPage.class);
                    startActivity(intent);
                }
                finish();
            }
        },opening_delay);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }
}
