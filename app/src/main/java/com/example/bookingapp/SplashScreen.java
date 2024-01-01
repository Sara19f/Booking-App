package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    Handler handler1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler1=new Handler();

        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ss=new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(ss);
            }
        },2300);

    }

}