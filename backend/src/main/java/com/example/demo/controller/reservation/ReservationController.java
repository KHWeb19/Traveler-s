package com.example.demo.controller.reservation;

import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;
import com.example.demo.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reserve")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/makeReservation")
    public String makeReservation(Integer roomId){
        log.info("makeReservation controller: {}", roomId);
        reservationService.createReservation(Long.valueOf(roomId));
        return "test...";
    }

    @GetMapping("/listReservation/{roomId}")
    public List<Reservation> listReservation(@PathVariable("roomId") Integer roomId){
        log.info("listReservation controller: {}", roomId);
        List<Reservation> reservations = reservationService.listReservationWithRoomId(Long.valueOf(roomId));
        return reservations;
    }

}
