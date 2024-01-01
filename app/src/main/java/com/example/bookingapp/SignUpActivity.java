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

public class SignUpActivity extends AppCompatActivity {

    TextView txtSignIn;
    EditText edtEmail, edtPassword;
    ProgressBar progressBar;
    Button btnSinUp;
    String  fEmail, fPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        txtSignIn = findViewById(R.id.txtSignIn);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        progressBar = findViewById(R.id.signUpProgressBar);
        btnSinUp = findViewById(R.id.btnSinUp);
        mAuth = FirebaseAuth.getInstance();

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fEmail=edtEmail.getText().toString().trim();
                fPassword=edtPassword.getText().toString().trim();


                    if (!TextUtils.isEmpty(fEmail)) {
                            if(!TextUtils.isEmpty(fPassword)){
                                SignUpUser();

                            } else {
                            edtEmail.setError("Enter a valid Email Address");

                        }

                    }else {
                        edtEmail.setError("Email Field can't be empty");
                    }

            }
        });


    }

    private void SignUpUser() {
        progressBar.setVisibility(View.VISIBLE);
        btnSinUp.setVisibility(View.INVISIBLE);

        mAuth.createUserWithEmailAndPassword(fEmail, fPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignUpActivity.this, "Sign Up Successful !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                btnSinUp.setVisibility(View.VISIBLE);
            }
        });

    }

}