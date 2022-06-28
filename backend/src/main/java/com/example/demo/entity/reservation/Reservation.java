package com.example.demo.entity.reservation;

import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.reservationroom.ReservationRoom;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany (mappedBy = "reservation", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonManagedReference
    private List<ReservationRoom> reservationRooms;
}
