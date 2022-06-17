package com.example.demo.entity.hotel;

import com.example.demo.dto.hotel.HotelConvert;
import com.example.demo.entity.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Convert(converter = HotelConvert.class)
    private List<String> hotelInfo;

    @Column(nullable = false)
    private String postcode;
      /*
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String detailAddress;

    // 참고항목
    @Column(nullable = false)
    private String extraAddress;
    */

    @Column(nullable = false)
    private String totalAddress;

    /*@Convert(converter = HotelConvert.class)
    private List<String> filePath;*/
    @Column(nullable = false) // default 255
    private String hotelImgPath1;
    @Column(nullable = false)
    private String hotelImgPath2;
    @Column(nullable = false)
    private String hotelImgPath3;
    @Column(nullable = false)
    private String hotelImgPath4;
    @Column(nullable = false)
    private String hotelImgPath5;
    @Column
    private String hotelImgPath6;
    @Column
    private String hotelImgPath7;
    @Column
    private String hotelImgPath8;
    @Column
    private String hotelImgPath9;

    @JsonIgnore
    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();
    //@Column(length = 300, nullable = false)
    //private String openKakaotalk;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}