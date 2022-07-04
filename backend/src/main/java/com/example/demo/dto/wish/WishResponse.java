package com.example.demo.dto.wish;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class WishResponse {
    private Long hotelNo;
    private Long wishNo;
    private String hotelName;
    private String totalAddress;

    public WishResponse(Long hotelNo ,Long wishNo,String hotelName, String totalAddress){
        this.hotelNo=hotelNo;
        this.wishNo=wishNo;
        this.hotelName=hotelName;
        this.totalAddress=totalAddress;
    }
}
