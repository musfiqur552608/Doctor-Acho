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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterDoctor extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private TextView textView2;
    private EditText regpass, regconpass, regmail, regName, regGender, regAge, empID ;

    private FirebaseAuth mAuth;

    private String currentUserID;

    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);

        button = findViewById(R.id.regidterBtn);
        textView2 = findViewById(R.id.haveBtn);
        regAge  = findViewById(R.id.registerAge);
        regpass = findViewById(R.id.registerPass);
        regconpass = findViewById(R.id.registerConPass);
        regmail = findViewById(R.id.docEmail);
        regName = findViewById(R.id.registerName);
        regGender= findViewById(R.id.registerGender);
        empID = findViewById(R.id.employeeId);

        mAuth = FirebaseAuth.getInstance();
        //currentUserID = mAuth.getCurrentUser().getUid();
        //databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
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
    private void CreateAccount() {
        final String empI = empID.getText().toString();
        final String email = regmail.getText().toString();
        String password = regpass.getText().toString();
        String confirmPass= regconpass.getText().toString();
        final String age= regAge.getText().toString();
        final String name= regName.getText().toString();
        final String gender= regGender.getText().toString();


        //Validation of empty string
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please, Enter your Email.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please, Enter your Password.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(empI))
        {
            Toast.makeText(this, "Please, Enter your Employee ID.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(confirmPass))
        {
            Toast.makeText(this, "Please, Confirm your Password.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(age))
        {
            Toast.makeText(this, "Please, Enter your Age.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please, Enter your Name.....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(gender))
        {
            Toast.makeText(this, "Please, Enter your Gender.....", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(confirmPass))
        {
            Toast.makeText(this, "Please, Enter your currect password", Toast.LENGTH_SHORT).show();
        }
        else
        {


            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {

                                Toast.makeText(RegisterDoctor.this, "Your account is created successfully.....", Toast.LENGTH_SHORT).show();


                                currentUserID = mAuth.getCurrentUser().getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserID);

                                HashMap userMap = new HashMap();
                                userMap.put("empI",empI);
                                userMap.put("email",email);
                                userMap.put("name",name);
                                userMap.put("age",age);
                                userMap.put("gender",gender);
                                databaseReference.updateChildren(userMap).addOnCompleteListener(new OnCompleteListener() {
                                    @Override
                                    public void onComplete(@NonNull Task task) {
                                        if(task.isSuccessful())
                                        {

                                            Toast.makeText(RegisterDoctor.this, " ", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            String message = task.getException().getMessage();
                                            Toast.makeText(RegisterDoctor.this, "Error:"+message, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                                Intent intent = new Intent(RegisterDoctor.this,HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {
                                String message = task.getException().getMessage();
                                Toast.makeText(RegisterDoctor.this, "Error Occured: "+message, Toast.LENGTH_SHORT).show();
                            }

                        }
                    });



        }
    }

}