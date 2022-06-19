package com.example.demo.dto.hotel;

import lombok.Data;

import java.util.List;

@Data
public class RoomRequest {
    String writer;
    String roomName;
    String roomType;
    List<String> roomInfo;
    int personnel;


    public RoomRequest (String writer,String roomName ,String roomType ,int personnel ,  List<String> roomInfo) {
        this.writer = writer;
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomInfo = roomInfo;
        this.personnel = personnel;
    }
}
