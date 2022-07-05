package com.example.demo.controller.reservation;

import com.example.demo.dto.reservation.ReservationRequest;
import com.example.demo.dto.reservation.ReservationResponse;
import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.Reservation;

import com.example.demo.repository.member.UserRepository;

import com.example.demo.service.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

        Reservation reservation = reservationService.createReservation(Long.valueOf(reservationRequest.getRoomId()), startDate, endDate);
        String no = reservation.getId().toString();
        return new ResponseEntity<>(no, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/user/readReservation")
    public ReservationResponse readReservation(@RequestParam Long reservationId) throws BadCredentialsException{
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByEmail(email).get();

        Optional<Reservation> optionalReservation = reservationService.findReservationById(reservationId);
        Reservation reservation = optionalReservation.get();
        log.info("reading Reservation");

        if (!user.getId().equals(reservation.getUser().getId()))
            throw new BadCredentialsException("Bad Credentials Exception");
        ReservationResponse reservationResponse = ReservationResponse.reservationResponseBuilderWithUser(reservation);
        return reservationResponse;
    }

    @GetMapping("/user/listAllReservations")
    public List<ReservationResponse> listAllReservations(){
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listAllReservations(user.getId());
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);
        return reservationResponses;
    }

    @GetMapping("/user/reservationListWithStatus")
    public List<ReservationResponse> listAllReservations(@RequestParam String status){
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsWithStatus(status, user.getId());
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);

        return reservationResponses;
    }

    @GetMapping("/ceo/listAllReservations")
    public List<ReservationResponse> ceoListAllReservations(){
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsForCEO(user.getId());
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);
        return reservationResponses;
    }
    @GetMapping("/ceo/reservationListWithStatus")
    public List<ReservationResponse> ceoListAllReservations(@RequestParam String status){
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userRepository.findByEmail(email).get();
        List<Reservation> reservations = reservationService.listReservationsByStatusForCEO(user.getId(), status);
        List<ReservationResponse> reservationResponses = ReservationResponse.reservationResponseListBuilder(reservations);
        return reservationResponses;
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> illegalStateException(){
        log.info("Handling Illegal State");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentailsException(){
        log.info("Handling Bad Credentials Exception");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
