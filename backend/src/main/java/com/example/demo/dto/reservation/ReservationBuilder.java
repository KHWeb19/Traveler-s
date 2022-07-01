package com.example.demo.dto.reservation;

import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.reservation.ReservationStatus;
import com.example.demo.entity.room.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationBuilder {

    public static Reservation reservationBuilder(Room room, User user) {
        Reservation reservation = Reservation.builder()
                .price(100000L)
                .status(ReservationStatus.PENDING)
                .endDate(LocalDate.parse("2022-03-26"))
                .startDate(LocalDate.parse("2022-03-27"))
                .room(room)
                .user(user)
                .build();

        return reservation;
    }
}
