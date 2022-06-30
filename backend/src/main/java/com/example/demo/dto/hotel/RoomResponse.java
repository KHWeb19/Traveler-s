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

    /*public static List<RoomResponse> roomBuilder(List<Room> rooms) {
        List<RoomResponse> roomRequestDTOList = rooms.stream().map(r -> RoomResponse.builder()
                .roomNo(r.getRoomNo())
                .roomImgPath1(r.getRoomImgPath1())
                .roomImgPath2(r.getRoomImgPath2())
                .roomImgPath3(r.getRoomImgPath3())
                .roomImgPath4(r.getRoomImgPath4())
                .roomImgPath5(r.getRoomImgPath5())
                .roomImgPath6(r.getRoomImgPath6())
                .roomImgPath7(r.getRoomImgPath7())
                .roomImgPath8(r.getRoomImgPath8())
                .roomImgPath9(r.getRoomImgPath9())
                .price(r.getPrice())
                .roomType(r.getRoomType())
                .roomInfo(r.getRoomInfo())
                .personnel(r.getPersonnel())
                .build()
        ).collect(Collectors.toList());

        return roomRequestDTOList;
    }

    public static RoomResponse roomBuilder(Room room) {
        RoomResponse roomRequestDTOList = RoomResponse.builder()
                .roomNo(room.getRoomNo())
                .roomImgPath1(room.getRoomImgPath1())
                .roomImgPath2(room.getRoomImgPath2())
                .roomImgPath3(room.getRoomImgPath3())
                .roomImgPath4(room.getRoomImgPath4())
                .roomImgPath5(room.getRoomImgPath5())
                .roomImgPath6(room.getRoomImgPath6())
                .roomImgPath7(room.getRoomImgPath7())
                .roomImgPath8(room.getRoomImgPath8())
                .roomImgPath9(room.getRoomImgPath9())
                .price(room.getPrice())
                .roomType(room.getRoomType())
                .roomInfo(room.getRoomInfo())
                .personnel(room.getPersonnel())
                .build();


        return roomRequestDTOList;
    }*/

}
