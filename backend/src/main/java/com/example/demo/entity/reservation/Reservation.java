package com.example.demo.entity.reservation;

import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private Date startDate;
    private Date endDate;

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonBackReference
    private Room room;

    public Reservation(Long price, ReservationStatus status, User user, Room room) {
        this.price = price;
        this.status = status;
        this.user = user;
        this.room = room;
    }
}
