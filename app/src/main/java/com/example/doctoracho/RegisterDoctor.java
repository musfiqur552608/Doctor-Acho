package com.example.doctoracho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterDoctor extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private TextView textView2;
    private EditText regpass, regconpass, regmail, regName, regGender, regAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);

        button = findViewById(R.id.regidterBtn);
        textView2 = findViewById(R.id.haveBtn);
        regAge  = findViewById(R.id.registerAge);
        regpass = findViewById(R.id.registerPass);
        regconpass = findViewById(R.id.registerConPass);
        regmail = findViewById(R.id.registerEmail);
        regName = findViewById(R.id.registerName);
        regGender= findViewById(R.id.registerGender);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterDoctor.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterDoctor.this,ShowActivity.class);
                startActivity(intent);
            }
        });
    }
}