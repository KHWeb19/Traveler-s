package com.example.demo.entity.hotel;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelNo;

    @Column(length = 20, nullable = false)
    private String hotelName;

    @Column
    private String writer;

    @Column
    private String hotelInfo;

    @Column(nullable = false)
    private String postcode;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detailAddress;

    // 참고항목
    @Column(nullable = false)
    private String extraAddress;

    @Column(nullable = false) // default 255
    private String hotelImgPath1;
    private String hotelImgPath2;
    private String hotelImgPath3;
    private String hotelImgPath4;
    private String hotelImgPath5;
    private String hotelImgPath6;
    private String hotelImgPath7;
    private String hotelImgPath8;
    private String hotelImgPath9;
    private String hotelImgPath10;

    @Column(length = 300, nullable = false)
    private String openKakaotalk;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
