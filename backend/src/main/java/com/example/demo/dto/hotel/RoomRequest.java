package com.example.demo.dto.hotel;

import lombok.Data;

import java.util.List;

@Data
public class RoomRequest {
    Long price;
    String roomType;
    List<String> roomInfo;
    int personnel;
    Long hotelNo;


    public RoomRequest (Long price ,String roomType ,int personnel ,Long hotelNo , List<String> roomInfo) {
        this.price = price;
        this.roomType = roomType;
        this.roomInfo = roomInfo;
        this.personnel = personnel;
        this.hotelNo = hotelNo;
    }
}
