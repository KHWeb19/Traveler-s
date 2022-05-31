package com.example.demo.entity.member.Hotel;

import lombok.Data;
import org.hibernate.annotations.Table;

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

    @Column(length = 512, nullable = false)
    private String hotelAddress;

    @Column(name = "hotel_Img")
    private String hotelImg;
}
