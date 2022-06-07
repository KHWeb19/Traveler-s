package com.example.demo.entity.Hotel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HotelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String infoId;

    @Column
    private int oceanView;

    @Column
    private int terrace;

    @Column
    private int swimmingPool;

    @Column
    private int carCharge;

    @Column
    private int nearAirport;

    @Column
    private int golfCourse;

    @Column
    private int freeParking;

    @Column
    private int bbqGrill;

    @Column
    private int pet;

    @Column
    private int pension;

    @Column
    private int spa;

    @Column
    private int ski;
}
