package com.example.demo.entity.room;

import com.example.demo.dto.hotel.HotelConvert;
import com.example.demo.entity.hotel.Hotel;

import com.example.demo.entity.reservation.Reservation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "hotel_no")
    private Hotel hotel;

    @Convert(converter = HotelConvert.class)
    private List<String> roomInfo;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Builder.Default
    private List<RoomImage> roomImages = new ArrayList<>();

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany (mappedBy = "room", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = false)
    @JsonManagedReference
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();

    public void addHotelToRoom(Hotel hotel){
        if (this.hotel != null){
            this.hotel.getRooms().remove(this);
        }
        this.hotel = hotel;
        hotel.getRooms().add(this);
    }

    public void addRoomImageToRoom(RoomImage roomImage){
        this.roomImages.add(roomImage);
        if (roomImage.getRoom() != this){
            roomImage.setRoom(this);
        }
    }

    public void removeRoomImageFromRoom(RoomImage roomImage){
        roomImages.remove(roomImage);
        roomImage.setRoom(null);
    }

}

