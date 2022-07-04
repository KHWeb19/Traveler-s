package com.example.demo.service.reservation;

import com.example.demo.dto.reservation.ReservationResponse;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void createReservation(Long roomId, LocalDate date);
    List<Reservation> listReservationWithRoomId(Long id, LocalDate date);

    List<ReservationResponse> reservationList(Long id );
}
