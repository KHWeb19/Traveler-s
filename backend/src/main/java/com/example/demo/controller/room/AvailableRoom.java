package com.example.demo.controller.room;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "room")
public class AvailableRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int numberOfRoom;

    @Column(nullable = false)
    private String useDate;

    @Column(nullable = false)
    private String checkDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "room_no")
    private Room room;

}
