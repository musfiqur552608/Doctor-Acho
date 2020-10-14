package com.example.doctoracho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegShowActivity extends AppCompatActivity {

    private ImageButton doctorbutton,userbutton;
    private TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_show);

        doctorbutton=findViewById(R.id.regDoctorId);
        userbutton=findViewById(R.id.Userid);
        textView=findViewById(R.id.regBtn2);

        doctorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegShowActivity.this,RegisterDoctor.class);
                startActivity(intent);
            }
        });

        userbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegShowActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegShowActivity.this,ShowActivity.class);
                startActivity(intent);

            }
        });

    }
}