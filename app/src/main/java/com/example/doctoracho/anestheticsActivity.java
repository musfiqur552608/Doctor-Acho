package com.example.doctoracho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class anestheticsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    reAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anesthetics);
        recyclerView = findViewById(R.id.anView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelNe> options =
                new FirebaseRecyclerOptions.Builder<modelNe>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users"),modelNe.class)
                        .build();

        adapter = new reAdapter(options);

        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}