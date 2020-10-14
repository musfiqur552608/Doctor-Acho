package com.example.doctoracho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdmin extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private EditText editMail, editPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        imageView=findViewById(R.id.log_image);
        button=findViewById(R.id.logBtn);
        editMail=findViewById(R.id.logEmail);
        editPass=findViewById(R.id.logPass);

        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllowingUserToLoginActivity();
            }
        });
    }
    private void AllowingUserToLoginActivity() {
        String email = editMail.getText().toString();
        String password = editPass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please, enter your email.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please, enter your password.....", Toast.LENGTH_SHORT).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent intent = new Intent(LoginAdmin.this,HomeActivity.class);
                                startActivity(intent);
                                Toast.makeText(LoginAdmin.this, "Loged in successfully....", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                String message = task.getException().getMessage();
                                Toast.makeText(LoginAdmin.this, "Error Occured: "+message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}