package com.sahanruwanga.medcarer;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class MedicationManager extends AppCompatActivity {
    MaterialSearchView searchView;
    EditText medicine;
    Fragment form;
    AddMedicalRecord addMedicalRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_manager);

        Fragment medicalHistory = new MedicalHistory();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly1,medicalHistory).commit();    //Open fragment

//        addMedicalRecord = (AddMedicalRecord)getSupportFragmentManager().findFragmentById(R.id.medicationManager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.medical_history);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        searchView = findViewById(R.id.searchViewMM);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
            }
            @Override
            public void onSearchViewClosed() {
            }
        });
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem item = menu.findItem(R.id.itemSearch);
        searchView.setMenuItem(item);
        getMenuInflater().inflate(R.menu.home, menu);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(searchView.isSearchOpen()){
            searchView.closeSearch();
        }else
            super.onBackPressed();
    }

    public void openAddForm(View view){
        form = new AddMedicalRecord();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly1,form).commit();
    }

    public void saveData(View view){
//        new User(this).save(new MedicalRecord(addMedicalRecord.disease.getText().toString().trim(),
//                addMedicalRecord.medicine.getText().toString().trim(),
//                addMedicalRecord.allergic.getText().toString().trim(), addMedicalRecord.date.getText().toString().trim(),
//                addMedicalRecord.doctorName.getText().toString().trim(),
//                addMedicalRecord.contact.getText().toString().trim(), addMedicalRecord.description.getText().toString().trim()));
        Toast.makeText(this,"Working:",Toast.LENGTH_LONG).show();
    }



}
