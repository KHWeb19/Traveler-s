package com.example.demo.dto.hotel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RoomRequest {

    Long roomNo;
    Long price;
    String roomType;
    List<String> roomInfo;
    int personnel;
    Long hotelNo;
    String writer;


    public RoomRequest (Long roomNo ,Long price ,String roomType ,int personnel ,Long hotelNo , List<String> roomInfo) {
        this.roomNo = roomNo;
        this.price = price;
        this.roomType = roomType;
        this.roomInfo = roomInfo;
        this.personnel = personnel;
        this.hotelNo = hotelNo;
    }

    public RoomRequest(String writer) {
        this.writer = writer;
    }

    public RoomRequest(Long hotelNo){
        this.hotelNo = hotelNo;
    }
}
