package com.sahanruwanga.medcarer.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sahanruwanga.medcarer.R;

public class StartPage extends AppCompatActivity {
    private String username;
    private TextView userNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        setUserNameTxt((TextView)findViewById(R.id.userNameTxt));
        setUsername(getIntent().getStringExtra("username"));
        getUserNameTxt().setText("username: "+username);

    }

    public void openHome(View view){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }

    //region Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TextView getUserNameTxt() {
        return userNameTxt;
    }

    public void setUserNameTxt(TextView userNameTxt) {
        this.userNameTxt = userNameTxt;
    }
    //endregion
}
