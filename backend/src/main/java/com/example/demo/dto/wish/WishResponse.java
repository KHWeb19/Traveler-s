package com.example.demo.dto.wish;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class WishResponse {
    private String hotelName;
    private String totalAddress;

    public WishResponse(String hotelName, String totalAddress){
        this.hotelName=hotelName;
        this.totalAddress=totalAddress;
    }
}
