package com.example.doctoracho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.User;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private TextView textView1;
    private Button button;
    private EditText editmail, editpass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView1 = findViewById(R.id.regBtn);
        button = findViewById(R.id.logBtn);
        editmail = findViewById(R.id.logEmail);
        editpass = findViewById(R.id.logPass);

        mAuth =FirebaseAuth.getInstance();

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegShowActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllowingUserToLoginActivity();

            }
        });

    }

    private void AllowingUserToLoginActivity() {
        String email = editmail.getText().toString();
        String password = editpass.getText().toString();

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
                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intent);
                                Toast.makeText(LoginActivity.this, "Loged in successfully....", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                String message = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this, "Error Occured: "+message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}