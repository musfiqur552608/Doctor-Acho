package com.example.doctoracho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ImageView neImage,caImage,anImage,gaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        neImage = findViewById(R.id.neImage);
        caImage = findViewById(R.id.caImage);
        anImage = findViewById(R.id.anImage);
        gaImage = findViewById(R.id.gaImage);

        neImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,neurologyActivity.class);
                startActivity(intent);

            }
        });
        caImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,cardiologyActivity.class);
                startActivity(intent);

            }
        });
        anImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,anestheticsActivity.class);
                startActivity(intent);

            }
        });
        gaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,gastroenterologyActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser =  mAuth.getCurrentUser();
        if(currentUser == null)
        {
            SendUserToLoginActivity();
        }
    }

    private void SendUserToLoginActivity() {
        Intent intent = new Intent(HomeActivity.this,ShowActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.neId){
            Intent intent = new Intent(HomeActivity.this,neurologyActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.caid){
            Intent intent = new Intent(HomeActivity.this,cardiologyActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.anId){
            Intent intent = new Intent(HomeActivity.this,anestheticsActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.gaId){
            Intent intent = new Intent(HomeActivity.this,gastroenterologyActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.logoutId){
                mAuth.signOut();
                SendUserToLoginActivity();

        }



        return super.onOptionsItemSelected(item);
    }
}