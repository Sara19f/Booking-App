package com.example.bookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.BreakIterator;
import java.util.Date;
import java.util.HashMap;

public class BookingActivity extends AppCompatActivity {

    private static final int YOUR_COST_PER_DAY_PER_STUDENT = 5;
    EditText eNoRoom, eNoHours, eDate;
    Button btClear,btCalculate, btBooking;
    TextView tPrice;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        eNoRoom= findViewById(R.id.editNoRoom);
        eNoHours= findViewById(R.id.editHours);
        eDate= findViewById(R.id.editTextDate);
        btClear= findViewById(R.id.bClear);
        btCalculate= findViewById(R.id.bCalculate);
        btBooking= findViewById(R.id.bBook);
        tPrice= findViewById(R.id.tPrice);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Rooms");
        btCalculate.setOnClickListener(v -> btCalculate());


   }

    private void btCalculate() {
        int numStudents = Integer.parseInt(eNoRoom.getText().toString());
        int numDays = Integer.parseInt(eNoHours.getText().toString());
        int totalCost = numStudents * numDays * YOUR_COST_PER_DAY_PER_STUDENT;

        //Set the result to textViewResult
        tPrice.setText("Total Cost: $" + totalCost);
    }





}