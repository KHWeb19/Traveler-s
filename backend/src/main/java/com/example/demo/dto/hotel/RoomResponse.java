package com.example.demo.dto.hotel;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.room.RoomImage;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {

    private Long roomNo;
    private String roomType;
    private Long price;
    private int personnel;
    private List<String> roomInfo;
    private Hotel hotel;
    private List<RoomImage> roomImage;
    private Date regDate;
    private Date updDate;

    public static List<RoomResponse> roomBuilder(List<Room> rooms) {
        List<RoomResponse> roomResponse = rooms.stream().map(r -> RoomResponse.builder()
                    .roomNo(r.getRoomNo())
                    .roomInfo(r.getRoomInfo())
                    .roomImage(r.getRoomImages())
                    .price(r.getPrice())
                    .roomType(r.getRoomType())
                    .roomInfo(r.getRoomInfo())
                    .personnel(r.getPersonnel())
                    .build()
            ).collect(Collectors.toList());

        return roomResponse;
    }

    public static RoomResponse roomBuilder(Room r) {
        RoomResponse roomResponse = RoomResponse.builder()
                .roomNo(r.getRoomNo())
                .roomType(r.getRoomType())
                .roomInfo(r.getRoomInfo())
                .roomImage(r.getRoomImages())
                .price(r.getPrice())
                .personnel(r.getPersonnel())
                .regDate(r.getRegDate())
                .build();
        
        return roomResponse;
    }

}
