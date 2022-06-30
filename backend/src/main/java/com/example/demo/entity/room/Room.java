package com.example.demo.entity.room;

import com.example.demo.dto.hotel.HotelConvert;
import com.example.demo.entity.hotel.Hotel;

import com.example.demo.entity.reservation.Reservation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomNo;

    @Column(length = 20, nullable = false)
    private String roomType;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private int personnel;

    @Convert(converter = HotelConvert.class)
    private List<String> roomInfo;

    @JsonBackReference
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

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany (mappedBy = "room", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = false)
    @JsonManagedReference
    private List<Reservation> reservations;

    public void addHotelToRoom(Hotel hotel){
        if (this.hotel != null){
            this.hotel.getRooms().remove(this);
        }
        this.hotel = hotel;
        hotel.getRooms().add(this);
    }

}

