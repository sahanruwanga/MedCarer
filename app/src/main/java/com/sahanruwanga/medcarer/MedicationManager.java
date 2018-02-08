package com.sahanruwanga.medcarer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.support.v7.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MedicationManager extends AppCompatActivity {
    AutoCompleteTextView name, disease, doctorName, doctorContact, description;
    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_manager);

        name = findViewById(R.id.nameTxt);
        disease = findViewById(R.id.diseaseTxt);
        doctorName = findViewById(R.id.doctorNameTxt);
        doctorContact = findViewById(R.id.contactTxt);
        description = findViewById(R.id.descriptionTxt);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        searchView = findViewById(R.id.searchView);
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
        getMenuInflater().inflate(R.menu.search_view,menu);
        MenuItem item = menu.findItem(R.id.itemSearch);
        searchView.setMenuItem(item);
        return true;
    }


    public void saveData(View view){
        new User(this).save(new Medication(name.getText().toString().trim(), disease.getText().toString().trim(),
                doctorName.getText().toString().trim(), doctorContact.getText().toString().trim(),
                "Date", description.getText().toString().trim()));

    }

    public void openAddForm(View view){

    }

}
