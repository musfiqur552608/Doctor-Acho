package com.example.doctoracho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginDoctor extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private EditText editMail, editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doctor);

        imageView=findViewById(R.id.log_image);
        button=findViewById(R.id.logBtn);
        editMail=findViewById(R.id.logEmail);
        editPass=findViewById(R.id.logPass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginDoctor.this,HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}