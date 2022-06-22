package com.example.demo.dto.hotel;

import lombok.Data;

import java.util.List;

@Data
public class RoomRequest {
    String roomName;
    String roomType;
    List<String> roomInfo;
    int personnel;
    Long hotelNo;


    public RoomRequest (String roomName ,String roomType ,int personnel ,Long hotelNo , List<String> roomInfo) {
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomInfo = roomInfo;
        this.personnel = personnel;
        this.hotelNo = hotelNo;
    }
}
