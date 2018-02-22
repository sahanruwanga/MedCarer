package com.sahanruwanga.medcarer.gui;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.sahanruwanga.medcarer.controllers.MedicalRecord;
import com.sahanruwanga.medcarer.R;
import com.sahanruwanga.medcarer.model.Model;

public class MedicalHistory extends Fragment {
    private RecyclerView recyclerView;
    private FloatingActionButton fBtn;
    private Model model;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_history, container, false);

        setModel(new Model());    //Object of the model class

        setRecyclerView((RecyclerView) view.findViewById(R.id.recyclerView));
        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    //region RecyclerView function
    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<MedicalRecord,MedicalRecordViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MedicalRecord, MedicalRecordViewHolder>
                (MedicalRecord.class,R.layout.layout_mh_list_item,MedicalRecordViewHolder.class, getModel().getReferenceToMedicalHistory()) {
            @Override
            protected void populateViewHolder(MedicalRecordViewHolder viewHolder, MedicalRecord medicalRecord, int position) {
                viewHolder.setDisease(medicalRecord.getDisease());
                viewHolder.setMedicine(medicalRecord.getMedicine());
                viewHolder.setDate(medicalRecord.getDate());
                viewHolder.setAllergic(medicalRecord.getAllergic());
            }
        };
        getRecyclerView().setAdapter(firebaseRecyclerAdapter);
    }

    public static class MedicalRecordViewHolder extends RecyclerView.ViewHolder{
        View view;
        public MedicalRecordViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }
        public void setDisease(String disease){
            TextView diseaseName = view.findViewById(R.id.mrDisease);
            diseaseName.setText(disease);
        }
        public void setMedicine(String medicine){
            TextView medicineName = view.findViewById(R.id.mrMedicine);
            medicineName.setText(medicine);
        }
        public void setDate(String date){
            TextView dateOf = view.findViewById(R.id.mrDate);
            dateOf.setText(date);
        }
        public void setAllergic(String allergic){
            TextView isAllergice = view.findViewById(R.id.mrAllergic);
            isAllergice.setText(allergic);
        }
    }

    //endregion

    //region Getters and Setters
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public FloatingActionButton getfBtn() {
        return fBtn;
    }

    public void setfBtn(FloatingActionButton fBtn) {
        this.fBtn = fBtn;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    //endregion

    public void openAddForm(View view){
    }

}
