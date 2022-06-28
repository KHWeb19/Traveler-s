package com.example.demo.entity.reservation.reservationroom;

import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ReservationRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Date createdDate;

    private Date startDate;
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
