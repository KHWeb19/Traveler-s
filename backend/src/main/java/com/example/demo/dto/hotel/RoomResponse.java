package com.example.demo.dto.hotel;


import lombok.Data;

@Data
public class RoomResponse {
    Long hotelNo;
    String hotelName;

    public RoomResponse (Long hotelNo, String hotelName) {
        this.hotelNo = hotelNo;
        this.hotelName =hotelName;
    }

}
