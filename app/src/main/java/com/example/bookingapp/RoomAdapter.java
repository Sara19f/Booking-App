package com.example.bookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RoomAdapter extends BaseAdapter {

    private Context context;
    private List<RoomModel> roomList;

    public RoomAdapter(Context context, List<RoomModel> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @Override
    public int getCount() {
        return roomList.size();
    }

    @Override
    public Object getItem(int position) {
        return roomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_details, parent, false);
        }

        // Bind data to UI elements
        TextView tvRoomName = convertView.findViewById(R.id.editNoRoom);
        TextView tvRoomDescription = convertView.findViewById(R.id.editHours);

        RoomModel room = roomList.get(position);

        tvRoomName.setText(room.getRoomName());
        tvRoomDescription.setText(room.getRoomDescription());

        return convertView;
    }
}