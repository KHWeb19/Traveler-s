package com.example.demo.repository.reservation;

import com.example.demo.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByRoom_RoomNo(@Param(value = "roomNo") Long roomNo);

}
