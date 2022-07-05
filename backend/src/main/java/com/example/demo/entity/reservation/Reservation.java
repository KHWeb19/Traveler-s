package com.example.demo.entity.reservation;

import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore
    private Room room;

}
