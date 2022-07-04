package com.example.demo.service.reservation;

import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void createReservation(Long roomId, LocalDate startDate, LocalDate endDate);
    List<Reservation> listAllReservations(Long userId);
    List<Reservation> listReservationsWithStatus(String status, Long userId);

    List<Reservation> listReservationsForCEO(Long userId);
    List<Reservation> listReservationsByStatusForCEO(Long userId, String status);



}
