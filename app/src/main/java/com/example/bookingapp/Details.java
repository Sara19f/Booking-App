package com.example.bookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView tR, tH, tP, tD;
        Button btnU, btnD, btnB;
          //-----------------------------------------TextView
        tR = findViewById(R.id.textNoRoom);
        tH   = findViewById(R.id.textNoHours);
        tP   = findViewById(R.id.textPrice);
        tD  = findViewById(R.id.textDate);
           //---------------------------------------------- Button
        btnU = findViewById(R.id.update);
        btnD    = findViewById(R.id.Delete);
        btnB   = findViewById(R.id.BackToHome);



        int hoursBooked = 0;
        double hourlyRate = 5.0;

        double totalCost = calculateBookingCost(hoursBooked, hourlyRate);
        System.out.println("Total Cost: $" + totalCost);
    }

    private static double calculateBookingCost(int hoursBooked, double hourlyRate) {
        if (hoursBooked < 0 || hourlyRate < 0) {
            // Handle invalid input
            throw new IllegalArgumentException("Hours booked and hourly rate must be non-negative");
        }

        // Calculate the total cost
        double totalCost = hoursBooked * hourlyRate;

        return totalCost;
    }
}



