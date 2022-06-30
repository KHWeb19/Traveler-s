package com.example.demo.dto.hotel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class HotelRequest {
    Long hotelNo;
    String hotelName;
    List<String> hotelInfo;
    String hotelIntro;
    String postcode;
    String totalAddress;


    public HotelRequest (List<String> hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public HotelRequest(String hotelName, List<String> hotelInfo,
                        String hotelIntro, String postcode, String totalAddress){
        this.hotelName = hotelName;
        this.hotelInfo =hotelInfo;
        this.hotelIntro = hotelIntro;
        this.postcode = postcode;
        this.totalAddress = totalAddress;
    }
}
