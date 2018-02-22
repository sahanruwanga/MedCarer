package com.sahanruwanga.medcarer.gui;

import android.os.Build;
import android.support.annotation.RequiresApi;
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
import com.sahanruwanga.medcarer.R;


public class MedicationManager extends AppCompatActivity {
    private MaterialSearchView searchView;
    private EditText medicine;
    private Fragment medicalRecord;
    private Fragment medicalHistory;
    private FragmentManager fragManager;
    private AddMedicalRecord addMedicalRecord;
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_manager);

        setFragManager(getSupportFragmentManager());
        getFragManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

            }
        });

        showMain();

        //region Search Bar Functions
        setSearchView((MaterialSearchView) findViewById(R.id.searchViewMM));
        getSearchView().setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
            }
            @Override
            public void onSearchViewClosed() {
            }
        });
        getSearchView().setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        //endregion
    }

    private void showMain(){
        setMedicalHistory(new MedicalHistory());
        getFragManager().beginTransaction().replace(R.id.ly1, getMedicalHistory()).commit();    //Open Medical History Fragment

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getToolbar());
        getSupportActionBar().setTitle(R.string.medical_history);
        getToolbar().setTitleTextColor(Color.parseColor("#000000"));
        getToolbar().setLogo(R.drawable.ic_download);                               //Toolbar creation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        if(getFragmentManager().cu)
            getMenuInflater().inflate(R.menu.search_view, menu);
            MenuItem item = menu.findItem(R.id.itemSearch);
            getSearchView().setMenuItem(item);
            getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(getSearchView().isSearchOpen()){
            getSearchView().closeSearch();
        }else if (getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else
            super.onBackPressed();
    }

    public void openAddForm(View view){
        setMedicalRecord(new AddMedicalRecord());
        getFragManager().beginTransaction().replace(R.id.ly1, getMedicalRecord()).addToBackStack(null).commit();
        getToolbar().setTitle(R.string.new_record);
        getToolbar().setLogo(R.drawable.ic_create);
    }


    public void saveData(View view){
//        new User(this).saveMedicalRecord(new MedicalRecord(addMedicalRecord.disease.getText().toString().trim(),
//                addMedicalRecord.medicine.getText().toString().trim(),
//                addMedicalRecord.allergic.getText().toString().trim(), addMedicalRecord.date.getText().toString().trim(),
//                addMedicalRecord.doctorName.getText().toString().trim(),
//                addMedicalRecord.contact.getText().toString().trim(), addMedicalRecord.description.getText().toString().trim()));
        Toast.makeText(this,"Working:",Toast.LENGTH_LONG).show();
    }


    //region Getters and Setters
    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public MaterialSearchView getSearchView() {
        return searchView;
    }

    public void setSearchView(MaterialSearchView searchView) {
        this.searchView = searchView;
    }

    public EditText getMedicine() {
        return medicine;
    }

    public void setMedicine(EditText medicine) {
        this.medicine = medicine;
    }

    public Fragment getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Fragment medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Fragment getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Fragment medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public AddMedicalRecord getAddMedicalRecord() {
        return addMedicalRecord;
    }

    public void setAddMedicalRecord(AddMedicalRecord addMedicalRecord) {
        this.addMedicalRecord = addMedicalRecord;
    }

    public FragmentManager getFragManager() {
        return fragManager;
    }

    public void setFragManager(FragmentManager fragManager) {
        this.fragManager = fragManager;
    }
    //endregion
}
