package com.example.demo.entity.room;

import com.example.demo.dto.hotel.HotelConvert;
import com.example.demo.entity.hotel.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table( name = "Room" )
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomNo;

    @Column(length = 20, nullable = false)
    private String roomName;

    @Column(length = 20, nullable = false)
    private String roomType;

    @Column(nullable = false)
    private int perssonel;

    @Convert(converter = HotelConvert.class)
    private List<String> roomInfo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "hotel_no")
    private Hotel hotel;

    @Column(nullable = false) // default 255
    private String roomImgPath1;
    @Column(nullable = false)
    private String roomImgPath2;
    @Column(nullable = false)
    private String roomImgPath3;
    @Column(nullable = false)
    private String roomImgPath4;
    @Column(nullable = false)
    private String roomImgPath5;
    @Column
    private String roomImgPath6;
    @Column
    private String roomImgPath7;
    @Column
    private String roomImgPath8;
    @Column
    private String roomImgPath9;


}

