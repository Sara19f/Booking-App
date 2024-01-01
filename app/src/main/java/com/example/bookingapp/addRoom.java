package com.example.bookingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class addRoom extends AppCompatActivity {

    private EditText editNo, eNoHours, eDate;
    private Button btnAddRoom, btnUpdateRoom, btnDeleteRoom;

    private DatabaseReference databaseReference;
    private List<RoomModel> roomList;
    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("rooms");

        // Initialize UI elements
        editNo = findViewById(R.id.editNoRoom);


        btnAddRoom = findViewById(R.id.bBook);



        // Initialize roomList and roomAdapter
        roomList = new ArrayList<>();
        roomAdapter = new RoomAdapter(this, roomList);


        // Load rooms from Firebase
        loadRooms();

        // Set click listener for adding a new room
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRoom();
            }
        });

//        // Set click listener for updating a room
//        btnUpdateRoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                updateRoom();
//            }
//        });
//
//        // Set click listener for deleting a room
//        btnDeleteRoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteRoom();
//            }
//        });
    }

    private void loadRooms() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                roomList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    RoomModel room = snapshot.getValue(RoomModel.class);
                    roomList.add(room);
                }
                roomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(addRoom.this, "Error loading rooms", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addRoom() {
        String roomName = editNo.getText().toString().trim();
        String roomDescription = eNoHours.getText().toString().trim();

        if (!roomName.isEmpty() && !roomDescription.isEmpty()) {
            String roomId = databaseReference.push().getKey();
            RoomModel newRoom = new RoomModel(roomId, roomName, roomDescription);

            if (roomId != null) {
                databaseReference.child(roomId).setValue(newRoom);
                Toast.makeText(this, "Room added successfully", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter room details", Toast.LENGTH_SHORT).show();
        }
    }

//    private void updateRoom() {
//        String roomName = editNo.getText().toString().trim();
//        String roomDescription = editTextRoomDescription.getText().toString().trim();
//
//        if (!roomName.isEmpty() && !roomDescription.isEmpty()) {
//            String roomId = databaseReference.push().getKey();
//            RoomModel newRoom = new RoomModel(roomId, roomName, roomDescription);
//
//            if (roomId != null) {
//                databaseReference.child(roomId).setValue(newRoom);
//                Toast.makeText(this, "Room added successfully", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(this, "Please enter room details", Toast.LENGTH_SHORT).show();
//
//        }
//    }



//    private void deleteRoom() {
//        String roomName = editTextRoomName.getText().toString().trim();
//        String roomDescription = editTextRoomDescription.getText().toString().trim();
//
//        if (!roomName.isEmpty() && !roomDescription.isEmpty()) {
//            String roomId = databaseReference.push().getKey();
//            RoomModel newRoom = new RoomModel(roomId, roomName, roomDescription);
//
//            if (roomId != null) {
//                databaseReference.child(roomId).setValue(newRoom);
//                Toast.makeText(this, "Room added successfully", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(this, "Please enter room details", Toast.LENGTH_SHORT).show();
//
//        }
//    }
}









