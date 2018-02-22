package com.sahanruwanga.medcarer.gui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sahanruwanga.medcarer.R;
import com.sahanruwanga.medcarer.model.Model;

public class WelcomePage extends AppCompatActivity {
    private static int opening_delay = 1500;
    private Model model;


    @Override
    protected void onStart() {
        super.onStart();
        setModel(new Model());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(model.getCurrentUser()!=null){
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

    //region Getter and Setters
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    //endregion
}
