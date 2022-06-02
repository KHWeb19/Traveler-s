package com.example.demo.entity.Hotel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelNo;

    @Column(length = 20, nullable = false)
    private String hotelName;

    @Column(length = 10, nullable = false)
    private String postcode;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String detailAddress;

    // 참고항목
    @Column(length = 20, nullable = false)
    private String extraAddress;

    // 현지님 요청 -> 카카오톡 링크
    @Column(length = 300, nullable = false)
    private String openKakaotalk;
}
