package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextView txtSignUp;
    EditText edtUserInName, edtInEmail, edtInPassword;
    ProgressBar progressBar;
    Button btnSinIn;
    String fUserName, fEmail, fPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSignUp = findViewById(R.id.txtSignUp);
        edtUserInName = findViewById(R.id.edtSignInEmail);
        edtInEmail = findViewById(R.id.edtSignInEmail);
        edtInPassword = findViewById(R.id.edtSignInPassword);
        progressBar = findViewById(R.id.signInProgressBar);
        btnSinIn = findViewById(R.id.btnSignIn);
        mAuth = FirebaseAuth.getInstance();

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSinIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fEmail = edtInEmail.getText().toString().trim();
                fPassword = edtInPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(fEmail)) {
                        if (!TextUtils.isEmpty(fPassword)) {
                            SignInUser();
                        } else {
                            edtInPassword.setError("Password Field can't be empty");
                        }
                } else {
                    edtInEmail.setError("Email Field can't be empty");
                }
            }
        });
    }

    private void SignInUser() {
        progressBar.setVisibility(View.VISIBLE);
        btnSinIn.setVisibility(View.INVISIBLE);

        mAuth.signInWithEmailAndPassword(fEmail, fPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error - " + e.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnSinIn.setVisibility(View.VISIBLE);
            }
        });

    }

    }
