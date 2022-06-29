package com.example.demo.dto.hotel;


import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelResponse {
    Long hotelNo;
    String hotelName;
    List<String> hotelInfo;
    String hotelIntro;
    String postcode;
    String writer;
    String totalAddress;
    String hotelImgPath1;
    String hotelImgPath2;
    String hotelImgPath3;
    String hotelImgPath4;
    String hotelImgPath5;
    String hotelImgPath6;
    String hotelImgPath7;
    String hotelImgPath8;
    String hotelImgPath9;
    Date regDate;


    public HotelResponse(Long hotelNo, String hotelName) {
        this.hotelNo = hotelNo;
        this.hotelName =hotelName;
    }

    public HotelResponse(Long hotelNo,String hotelImgPath1, String hotelName, String totalAddress, List<String> hotelInfo) {
        this.hotelNo = hotelNo;
        this.hotelImgPath1 = hotelImgPath1;
        this.hotelName = hotelName;
        this.totalAddress = totalAddress;
        this.hotelInfo = hotelInfo;
    }

    public static List<HotelResponse> hotelBuilder(List<Hotel> hotels) {
        List<HotelResponse> hotelRequestDTOList = hotels.stream().map(h -> HotelResponse.builder()
                .hotelNo(h.getHotelNo())
                .hotelName(h.getHotelName())
                .hotelImgPath1(h.getHotelImgPath1())
                .hotelImgPath2(h.getHotelImgPath2())
                .hotelImgPath3(h.getHotelImgPath3())
                .hotelImgPath4(h.getHotelImgPath4())
                .hotelImgPath5(h.getHotelImgPath5())
                .hotelImgPath6(h.getHotelImgPath6())
                .hotelImgPath7(h.getHotelImgPath7())
                .hotelImgPath8(h.getHotelImgPath8())
                .hotelImgPath9(h.getHotelImgPath9())
                .hotelInfo(h.getHotelInfo())
                .hotelIntro(h.getHotelIntro())
                .postcode(h.getPostcode())
                .totalAddress(h.getTotalAddress())
                .regDate(h.getRegDate())
                .writer(h.getUser().getEmail())
                .build()
        ).collect(Collectors.toList());

        return hotelRequestDTOList;
    }

    public static HotelResponse hotelBuilder(Hotel hotel) {
        HotelResponse hotelRequestDTO = HotelResponse.builder()
                .hotelNo(hotel.getHotelNo())
                .hotelName(hotel.getHotelName())
                .hotelImgPath1(hotel.getHotelImgPath1())
                .hotelImgPath2(hotel.getHotelImgPath2())
                .hotelImgPath3(hotel.getHotelImgPath3())
                .hotelImgPath4(hotel.getHotelImgPath4())
                .hotelImgPath5(hotel.getHotelImgPath5())
                .hotelImgPath6(hotel.getHotelImgPath6())
                .hotelImgPath7(hotel.getHotelImgPath7())
                .hotelImgPath8(hotel.getHotelImgPath8())
                .hotelImgPath9(hotel.getHotelImgPath9())
                .hotelInfo(hotel.getHotelInfo())
                .hotelIntro(hotel.getHotelIntro())
                .postcode(hotel.getPostcode())
                .totalAddress(hotel.getTotalAddress())
                .regDate(hotel.getRegDate())
                .writer(hotel.getUser().getEmail())
                .build();


        return hotelRequestDTO;
    }
}
