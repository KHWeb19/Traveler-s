package com.example.demo.controller.hotel.response;

import lombok.Data;

import java.util.List;

@Data
public class HotelResponse {
    private String hotelImgPath1;
    private String hotelName;
    private String totalAddress;
    private List<String> hotelInfo;

    public HotelResponse (String hotelImgPath1, String hotelName, String totalAddress, List<String> hotelInfo) {
        this.hotelImgPath1 = hotelImgPath1;
        this.hotelName = hotelName;
        this.totalAddress = totalAddress;
        this.hotelInfo = hotelInfo;
    }
}
