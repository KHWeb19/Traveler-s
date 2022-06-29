package com.example.demo.dto.hotel;

import com.example.demo.entity.hotel.Hotel;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class RoomResponseDTO {

    private Long roomNo;
    private String roomType;
    private Long price;
    private int personnel;
    private List<String> roomInfo;
    private Hotel hotel;
    private String roomImgPath1;
    private String roomImgPath2;
    private String roomImgPath3;
    private String roomImgPath4;
    private String roomImgPath5;
    private String roomImgPath6;
    private String roomImgPath7;
    private String roomImgPath8;
    private String roomImgPath9;

    private Date regDate;
    private Date updDate;

}
