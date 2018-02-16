package com.sahanruwanga.medcarer;


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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicalHistory extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FloatingActionButton fBtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_history, container, false);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("users");
        databaseReference.keepSynced(true);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<MedicalRecord,MedicalRecordViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MedicalRecord, MedicalRecordViewHolder>
                (MedicalRecord.class,R.layout.layout_mh_list_item,MedicalRecordViewHolder.class,databaseReference) {
            @Override
            protected void populateViewHolder(MedicalRecordViewHolder viewHolder, MedicalRecord model, int position) {
                viewHolder.setDisease(model.getDisease());
                viewHolder.setMedicine(model.getMedicine());
                viewHolder.setDate(model.getDate());
                viewHolder.setAllergic(model.getAllergic());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
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

    public void openAddForm(View view){

    }

}
