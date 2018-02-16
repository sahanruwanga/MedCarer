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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sahan Ruwanga on 2/2/2018.
 */

public class User {
    private String email;
    private String password;
    private Activity activity;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;
    private DatabaseReference databaseReference;

    public User(String email, String password, Activity activity){
        this.email = email;
        this.password = password;
        this.activity = activity;
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        register(email,password);
    }

    public User(Activity activity){
        this.activity = activity;
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void login(String username,String password){
        firebaseAuth.signInWithEmailAndPassword(username,password)
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
        firebaseAuth.createUserWithEmailAndPassword(username,password)
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
        firebaseAuth.signOut();
        Intent intent = new Intent(activity, LoginPage.class);
        activity.startActivity(intent);
        activity.finish();
    }

    public FirebaseUser checkCurrentUser(){
        return firebaseAuth.getCurrentUser();
    }

    public void save(MedicalRecord obj){
        databaseReference.child("users").child(checkCurrentUser().getUid()).child("medication_history").push().setValue(obj);
    }

}
