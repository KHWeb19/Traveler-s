package com.example.demo.controller.reservation;

import com.example.demo.dto.reservation.ReservationRequest;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;
import com.example.demo.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reserve")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/makeReservation")
    public ResponseEntity<?> makeReservation(@RequestBody ReservationRequest reservationRequest){
        log.info("makeReservation controller: {}", reservationRequest.getId());
        LocalDate date = LocalDate.parse(reservationRequest.getDate());
        log.info("Reservation Date: {}", date);
        reservationService.createReservation(Long.valueOf(reservationRequest.getId()), date);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/listReservation")
    public List<Reservation> listReservation(@RequestBody ReservationRequest reservationRequest){
        log.info("listReservation controller: {}", reservationRequest.getId());
        LocalDate date = LocalDate.parse(reservationRequest.getDate());
        log.info("Reservation Date: {}", date);

        List<Reservation> reservations = reservationService.listReservationWithRoomId(Long.valueOf(reservationRequest.getId()), date);
        return reservations;
    }

}
