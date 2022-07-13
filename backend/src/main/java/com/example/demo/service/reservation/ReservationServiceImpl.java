package com.example.demo.service.reservation;

import com.example.demo.dto.reservation.ReservationResponse;
import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.reservation.ReservationStatus;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.reservation.ReservationRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public Reservation createReservation(Long roomId, LocalDate startDate, LocalDate endDate) throws IllegalStateException {
        log.info("createReservation in serviceImpl");
        List<Reservation> reservationList = reservationRepository.findByRoom_RoomNo(roomId);

        boolean canMakeReservation = true;

        if (!reservationList.isEmpty()) {
            //private method 인자값 room이 enddate가 date값보다 작은 reservation을 갖고있다면 return true
            canMakeReservation = validateRoom(reservationList, startDate, endDate);
        }
        if (!canMakeReservation)
            throw new IllegalStateException("Cannot make a reservation");
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.get();
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        Room room = optionalRoom.get();

        Reservation reservation = Reservation.builder()
                .price(room.getPrice())
                .status(ReservationStatus.PENDING)
                .startDate(startDate)
                .endDate(endDate)
                .room(room)
                .user(user)
                .build();
        reservationRepository.save(reservation);
        log.info("Created reservation");
        return reservation;
    }

    @Override
    public Optional<Reservation> findReservationById(Long reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        return optionalReservation;
    }

    @Override
    public List<Reservation> listAllReservations(Long userId) {
        List<Reservation> reservations = reservationRepository.findByUser_id(userId);

        return reservations;
    }

    @Override
    public List<Reservation> listReservationsWithStatus(String status, Long userId) {
        ReservationStatus reservationStatus = ReservationStatus.valueOf(status);
        List<Reservation> reservations = reservationRepository.findByStatusAndUser_id(reservationStatus, userId);
        return reservations;
    }

    @Override
    public List<Reservation> listReservationsForCEO(Long userId) {
        List<Reservation> reservationsForCEO = reservationRepository.findReservationsForCEO(userId);
        return reservationsForCEO;
    }

    @Override
    public List<Reservation> listReservationsByStatusForCEO(Long userId, String status) {
        ReservationStatus reservationStatus = ReservationStatus.valueOf(status);
        List<Reservation> reservationsByStatusForCEO = reservationRepository.findReservationsByStatusForCEO(userId, reservationStatus);
        return reservationsByStatusForCEO;
    }

    @Override
    public void cancelReservation(String id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(Long.valueOf(id));
        if (optionalReservation.isEmpty())
            throw new NoSuchElementException("Reservation does not exist");

        Reservation reservation = optionalReservation.get();

        if (!reservation.getStatus().equals(ReservationStatus.PENDING))
            throw new IllegalStateException("Reservation Status is not Pending");
        if (reservation.getEndDate().isBefore(ChronoLocalDate.from(LocalDateTime.now())))
            throw new IllegalStateException("Reservation Date Overdue");

        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
        log.info("Reservation cancelled");
    }

    private boolean validateRoom(List<Reservation> reservations, LocalDate startDate, LocalDate endDate){
        log.info("validateRoom method");
        //Optional<Reservation> optionalReservation = reservations.stream().filter(f -> !(f.getEndDate().isBefore(startDate) && !(f.getStartDate().isAfter(endDate)))).findFirst();
        Optional<Reservation> optionalReservation = reservations.stream().filter(f -> startDate.isBefore(f.getEndDate()) && !(endDate.isBefore(f.getStartDate()))).findFirst();
        //Optional<Reservation> optionalReservation = reservations.stream().filter(f -> !(f.getEndDate().isAfter(startDate)) && !(endDate.isBefore(f.getStartDate()))).findFirst();

        if (optionalReservation.isEmpty()) {
            log.info("Can make reservation.");
            return true;
        }

        log.info("Cannot make reservation.");
        return false;
    }

}
