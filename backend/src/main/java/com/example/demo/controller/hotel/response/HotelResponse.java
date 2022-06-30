package com.example.demo.controller.hotel.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class HotelResponse {
    private Long hotelNo;
    private String hotelImgPath1;
    private String hotelName;
    private String totalAddress;
    private List<String> hotelInfo;

    public HotelResponse(Long hotelNo,String hotelImgPath1, String hotelName, String totalAddress, List<String> hotelInfo) {
        this.hotelNo = hotelNo;
        this.hotelImgPath1 = hotelImgPath1;
        this.hotelName = hotelName;
        this.totalAddress = totalAddress;
        this.hotelInfo = hotelInfo;
    }

}
