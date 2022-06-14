package com.example.demo.dto.hotel;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class HotelRequest {
    List<String> hotelInfo;

    public HotelRequest (List<String> hotelInfo) {
        this.hotelInfo = hotelInfo;
    }
}
