package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivitysc02 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView txtRegister;
    private EditText  txtEmail, txtPass;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysc02);
        txtRegister = findViewById(R.id.txtRegister);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        mAuth = FirebaseAuth.getInstance();
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitysc02.this,MainActivitysc03.class);
                startActivity(intent);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = txtEmail.getText().toString().trim();
                String strPass = txtPass.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(MainActivitysc02.this,MainActivityfinal.class);
                            startActivity(intent);
                            finishAffinity();
                        }else{
                            Intent intent = new Intent(MainActivitysc02.this,MainActivitysc03.class);
                            startActivity(intent);
                            finishAffinity();
                        }
                    }
                });
            }
        });

    }

}