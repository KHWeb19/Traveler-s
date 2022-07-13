package com.example.demo.service.reservation;

import com.example.demo.dto.reservation.ReservationResponse;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Long roomId, LocalDate startDate, LocalDate endDate);
    List<Reservation> listAllReservations(Long userId);
    List<Reservation> listReservationsWithStatus(String status, Long userId);
    Optional<Reservation> findReservationById(Long reservationId);

    List<Reservation> listReservationsForCEO(Long userId);
    List<Reservation> listReservationsByStatusForCEO(Long userId, String status);

    void cancelReservation(String id);
}
