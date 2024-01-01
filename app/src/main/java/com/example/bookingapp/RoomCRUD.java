package com.example.bookingapp;

import android.util.Log;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoomCRUD {

    private DatabaseReference roomsReference;

    public RoomCRUD() {
        // Initialize Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        roomsReference = firebaseDatabase.getReference("Rooms");
    }

    // CREATE - Add a new room to the database
    public void addRoom(Room room) {
        String roomId = roomsReference.push().getKey();
        room.setRoomId(roomId);
        roomsReference.child(roomId).setValue(room);
    }

    // READ - Retrieve all rooms from the database
    public void retrieveRooms() {
        roomsReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Room room = dataSnapshot.getValue(Room.class);
                Log.d("RoomCRUD", "Room added: " + room.getRoomName());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                // Handle room data change
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                // Handle room removal
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                // Handle room movement
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("RoomCRUD", "Database Error: " + databaseError.getMessage());
            }
        });
    }

    // UPDATE - Update details of an existing room
    public void updateRoom(Room room) {
        roomsReference.child(room.getRoomId()).setValue(room);
    }

    // DELETE - Remove a room from the database
    public void deleteRoom(String roomId) {
        roomsReference.child(roomId).removeValue();
    }


}
