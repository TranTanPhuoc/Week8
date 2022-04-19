package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivitysc03 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText txtName,txtEmail,txtPass,txtPass2;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysc03);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmailRegister);
        txtPass = findViewById(R.id.txtPasswordRegister);
        txtPass2 = findViewById(R.id.txtPasswordRegister2);
        btnSignUp = findViewById(R.id.btnSignIn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = txtEmail.getText().toString().trim();
                String strPass = txtPass.getText().toString().trim();
                String strPass2 = txtPass2.getText().toString().trim();
                if(strPass.equalsIgnoreCase(strPass2)){
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(MainActivitysc03.this,MainActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            }else{
                                Toast.makeText(MainActivitysc03.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }

}