package com.example.demo.service.reservation;

import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;

import java.util.List;

public interface ReservationService {
    void createReservation(Long roomId);
    List<Reservation> listReservationWithRoomId(Long id);
}
