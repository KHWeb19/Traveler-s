package com.example.demo.controller.room;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "room")
public class AvailableRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long numberOfRoom;

    @Column(nullable = false)
    private String useDate;

    @Column(nullable = false)
    private String checkDate;


}
