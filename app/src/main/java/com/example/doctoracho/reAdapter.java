package com.example.doctoracho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class reAdapter extends FirebaseRecyclerAdapter<modelNe,reAdapter.myviewholder> {

    public reAdapter(@NonNull FirebaseRecyclerOptions<modelNe> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder myviewholder, int i, @NonNull modelNe modelNe) {
        myviewholder.emp.setText("Employee ID: "+modelNe.getEmpI());
        myviewholder.name.setText("Name: "+modelNe.getName());
        myviewholder.email.setText("Email:"+modelNe.getEmail());
        myviewholder.age.setText("Age: "+modelNe.getAge());
        myviewholder.gender.setText("Gender: "+modelNe.getGender());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reline,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView emp,name,email,age,gender;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            emp=(TextView) itemView.findViewById(R.id.empI);
            name = (TextView) itemView.findViewById(R.id.nameid);
            email = (TextView) itemView.findViewById(R.id.emailid);
            age = (TextView) itemView.findViewById(R.id.ageid);
            gender = (TextView) itemView.findViewById(R.id.genderid);
        }
    }

}
