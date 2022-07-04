package com.example.demo.repository.reservation;

import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.reservation.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoom_RoomNo(@Param(value = "roomNo") Long roomNo);
    List<Reservation> findByUser_id(@Param(value = "id") Long userId);
    List<Reservation> findByStatusAndUser_id(ReservationStatus status, @Param(value ="id") Long userId);

    @Query("select r from Reservation r join r.room rm join rm.hotel h join h.user u where u.id = :userId")
    List<Reservation> findReservationsForCEO(Long userId);

    @Query("select r from Reservation r join r.room rm join rm.hotel h join h.user u where u.id = :userId and r.status = :status")
    List<Reservation> findReservationsByStatusForCEO(Long userId, ReservationStatus status);
}
