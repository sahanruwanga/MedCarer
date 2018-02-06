package com.sahanruwanga.medcarer;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Sahan Ruwanga on 2/2/2018.
 */

public class User {
    private String email;
    private String password;
    private Activity activity;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    public User(String email, String password, Activity activity){
        this.email = email;
        this.password = password;
        this.activity = activity;
        setFirebaseAuth(FirebaseAuth.getInstance());
        register(email,password);
    }

    public User(Activity activity){
        this.activity = activity;
        setFirebaseAuth(FirebaseAuth.getInstance());
    }

    public void login(String username,String password){
        getFirebaseAuth().signInWithEmailAndPassword(username,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(activity, Home.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }else{
                            Toast.makeText(activity,"Login failed!\nEnter correct username and password.",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void register(final String username, final String password){
        getFirebaseAuth().createUserWithEmailAndPassword(username,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(activity, StartPage.class);
//                            intent.putExtra("exUsername",username);
//                            intent.putExtra("exPassword",password);
                            intent.putExtra("username",username);
                            activity.startActivity(intent);
                            activity.finish();
                        }else{
                            Toast.makeText(activity,"Something wrong!\nCheck Internet connection and try again!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void registerUsingPhoneNo(String username, String password){

    }

    public void updateDetails(){

    }

    public void logout(){
        getFirebaseAuth().signOut();
        Intent intent = new Intent(activity,LoginPage.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public FirebaseUser checkCurrentUser(){
        return getFirebaseAuth().getCurrentUser();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }
}
