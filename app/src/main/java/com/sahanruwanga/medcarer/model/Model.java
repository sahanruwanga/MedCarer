package com.sahanruwanga.medcarer.model;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sahanruwanga.medcarer.controllers.MedicalRecord;
import com.sahanruwanga.medcarer.controllers.User;
import com.sahanruwanga.medcarer.gui.Home;
import com.sahanruwanga.medcarer.gui.LoginPage;
import com.sahanruwanga.medcarer.gui.StartPage;


/**
 * Created by Sahan Ruwanga on 2/19/2018.
 */

public class Model {
    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;
    private DatabaseReference databaseReference;
    private User user;

    public Model(){
        this.setFirebaseAuth(FirebaseAuth.getInstance());
        this.setDatabaseReference(FirebaseDatabase.getInstance().getReference());
        this.setCurrentUser(getFirebaseAuth().getCurrentUser());
    }


    public DatabaseReference getReferenceToMedicalHistory(){
        DatabaseReference dbReference= getDatabaseReference().child("users");
        dbReference.keepSynced(true);
        return dbReference;
    }


    //region Register | Login | Logout
    public void userRegistration(final User user, final Activity activity){
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(activity, StartPage.class);
                            intent.putExtra("username",user.getEmail());
                            activity.startActivity(intent);
                            activity.finish();
                        }else{
                            Toast.makeText(activity,"Something wrong!\nCheck Internet connection and try again!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void userLogin(final User user, final Activity activity){
        firebaseAuth.signInWithEmailAndPassword(user.getEmail(),user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            updateUserProfile(user);
                            Intent intent = new Intent(activity, Home.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }else{
                            Toast.makeText(activity,"Login failed!\nEnter correct username and password.",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void userLogout(Activity activity){
        getFirebaseAuth().signOut();
        Intent intent = new Intent(activity, LoginPage.class);
        activity.startActivity(intent);
        activity.finish();
    }
    //endregion


    public void saveMedicalRecord(MedicalRecord medicalRecord){
        this.getDatabaseReference().child("users").child(this.getCurrentUser().getUid()).child("medication_history")
                .setValue(medicalRecord);
    }

    public void updateUserProfile(User user){

    }


    //region Getter and Setter
    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(FirebaseUser currentUser) {
        this.currentUser = currentUser;
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void setDatabaseReference(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }
    //endregion

}
