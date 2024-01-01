package com.example.bookingapp;

public class Room {
    private String roomId;
    private String roomName;
    private String roomDetails;

    public Room(String roomId, String roomName, String roomDetails) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomDetails = roomDetails;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(String roomDetails) {
        this.roomDetails = roomDetails;
    }

    // Constructors, getters, setters...


}