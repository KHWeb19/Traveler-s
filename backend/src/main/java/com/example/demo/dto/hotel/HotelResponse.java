package com.example.demo.dto.hotel;


import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.hotel.HotelImage;
import com.example.demo.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
    List<String> hotelImages;
    Date regDate;

    public HotelResponse(Long hotelNo, String hotelName) {
        this.hotelNo = hotelNo;
        this.hotelName =hotelName;
    }

    public HotelResponse(Long hotelNo, String hotelFirstImage, String hotelName, String totalAddress, List<String> hotelInfo) {
        this.hotelNo = hotelNo;
        this.hotelImages = List.of(hotelFirstImage);
        this.hotelName = hotelName;
        this.totalAddress = totalAddress;
        this.hotelInfo = hotelInfo;
    }

    public static List<HotelResponse> hotelBuilder(List<Hotel> hotels) {
        List<HotelResponse> hotelRequestDTOList = hotels.stream().map(h -> HotelResponse.builder()
                .hotelNo(h.getHotelNo())
                .hotelName(h.getHotelName())
                .hotelImages(h.getHotelImages().stream().map(hotelImage-> hotelImage.getPath())
                        .collect(Collectors.toList()))
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
                .hotelImages(hotel.getHotelImages().stream().map(hotelImage -> hotelImage.getPath())
                        .collect(Collectors.toList()))
                .hotelInfo(hotel.getHotelInfo())
                .hotelIntro(hotel.getHotelIntro())
                .postcode(hotel.getPostcode())
                .totalAddress(hotel.getTotalAddress())
                .regDate(hotel.getRegDate())
                .writer(hotel.getUser().getEmail())
                .build();


        return hotelRequestDTO;
    }

    public static List<HotelResponse> hotelBuilder(Set<Hotel> hotels) {
        List<HotelResponse> hotelRequestDTOList = hotels.stream().map(h -> HotelResponse.builder()
                .hotelNo(h.getHotelNo())
                .hotelName(h.getHotelName())
                .hotelImages(h.getHotelImages().stream().map(hotelImage-> hotelImage.getPath())
                        .collect(Collectors.toList()))
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
}
