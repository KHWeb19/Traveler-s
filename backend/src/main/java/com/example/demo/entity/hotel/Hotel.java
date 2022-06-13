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

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(length = 10, nullable = false)
    private String postcode;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String detailAddress;

    // 참고항목
    @Column(length = 20, nullable = false)
    private String extraAddress;

    @Column(nullable = false) // default 255
    private String hotelImgPath;

    @Column(length = 300, nullable = false)
    private String openKakaotalk;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

}
