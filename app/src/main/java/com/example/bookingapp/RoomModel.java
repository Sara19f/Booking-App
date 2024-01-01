package com.example.bookingapp;

public class RoomModel {

    private String roomId;
    private  String RoomName;
    private  String RoomDescription;



    public RoomModel(String roomId, String roomName, String roomDescription) {
    }


    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        RoomDescription = roomDescription;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}