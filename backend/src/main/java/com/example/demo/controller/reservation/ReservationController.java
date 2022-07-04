package com.example.demo.controller.reservation;

import com.example.demo.dto.reservation.ReservationRequest;
import com.example.demo.dto.reservation.ReservationResponse;
import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reserve/")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final UserRepository userRepository;

    @PostMapping("/user/makeReservation")
    public ResponseEntity<?> makeReservation(@RequestBody ReservationRequest reservationRequest){
        log.info("makeReservation controller: {}", reservationRequest.getRoomId());
        LocalDate startDate = LocalDate.parse(reservationRequest.getStartDate());
        LocalDate endDate = LocalDate.parse(reservationRequest.getEndDate());

        reservationService.createReservation(Long.valueOf(reservationRequest.getRoomId()), startDate, endDate);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/listAllReservations")
    public List<Reservation> listAllReservations(){
        //String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String email = "user@gmail.com";
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listAllReservations(user.getId());
        return reservations;
    }

    @GetMapping("/user/reservationListWithStatus")
    public List<Reservation> listAllReservations(@RequestParam String status){
        //String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String email = "user@gmail.com";
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsWithStatus(status, user.getId());
        return reservations;
    }

    @GetMapping("/ceo/listAllResevations")
    public List<ReservationResponse> ceoListAllReservations(){
        //String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String email = "ceo@gmail.com";
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsForCEO(user.getId());
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);
        return reservationResponses;
    }
    @GetMapping("/ceo/reservationListWithStatus")
    public List<Reservation> ceoListAllReservations(@RequestParam String status){
        //String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        String email = "ceo@gmail.com";
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsByStatusForCEO(user.getId(), status);
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);
        return reservations;
    }

}
