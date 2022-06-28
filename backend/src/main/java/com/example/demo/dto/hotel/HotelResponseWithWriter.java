package com.example.demo.dto.hotel;
import com.example.demo.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class HotelResponseWithWriter {
    private Long hotelNo;
    private String hotelName;
    private List<String> hotelInfo;
    private String hotelIntro;
    private String postcode;
    private String totalAddress;

    private String hotelImgPath1;
    private String hotelImgPath2;
    private String hotelImgPath3;
    private String hotelImgPath4;
    private String hotelImgPath5;
    private String hotelImgPath6;

    @Builder.Default
    private List<Room> rooms = new ArrayList<>();

    private String openKakaotalk;
    private Date regDate;
    private Date updDate;
    private String writer;


}
