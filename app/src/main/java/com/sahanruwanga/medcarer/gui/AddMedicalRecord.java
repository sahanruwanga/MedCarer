package com.sahanruwanga.medcarer.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sahanruwanga.medcarer.controllers.MedicalRecord;
import com.sahanruwanga.medcarer.R;
import com.sahanruwanga.medcarer.controllers.User;

public class AddMedicalRecord extends Fragment implements View.OnClickListener {

    EditText disease, medicine, allergic, date,  doctorName, contact, description;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_medical_record, container, false);

        disease = view.findViewById(R.id.diseaseTxt);
        medicine = view.findViewById(R.id.medicineTxt);
        allergic = view.findViewById(R.id.allergicTxt);
        date = view.findViewById(R.id.dateTxt);
        doctorName = view.findViewById(R.id.doctorTxt);
        contact = view.findViewById(R.id.contactTxt);
        description = view.findViewById(R.id.descriptionTxt);
        button = view.findViewById(R.id.saveBtn);
        button.setOnClickListener(this);
        return view;
    }



    public void saveData(){
        new User(new MedicationManager()).saveMedicalRecord(new MedicalRecord(disease.getText().toString().trim(), medicine.getText().toString().trim(),
                allergic.getText().toString().trim(), date.getText().toString().trim(), doctorName.getText().toString().trim(),
                contact.getText().toString().trim(), description.getText().toString().trim()));

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.saveBtn)
            saveData();
    }
}
