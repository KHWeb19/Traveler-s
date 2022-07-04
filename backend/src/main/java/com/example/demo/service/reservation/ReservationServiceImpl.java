package com.example.demo.service.reservation;

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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public void createReservation(Long roomId, LocalDate startDate, LocalDate endDate) {
        log.info("createReservation in serviceImpl");
        List<Reservation> reservationList = reservationRepository.findByRoom_RoomNo(roomId);

        boolean canMakeReservation = true;

        if (!reservationList.isEmpty()){
            //private method 인자값 room이 enddate가 date값보다 작은 reservation을 갖고있다면 return true
            canMakeReservation = validateRoom(reservationList, startDate, endDate);
        }
        try {
            if (!canMakeReservation)
                throw new IllegalStateException("Cannot make a reservation");
            Optional<User> optionalUser = userRepository.findByEmail("user@gmail.com");
            User user = optionalUser.get();
            Optional<Room> optionalRoom = roomRepository.findById(roomId);
            Room room = optionalRoom.get();

            Reservation reservation = Reservation.builder()
                    .price(100000L)
                    .status(ReservationStatus.PENDING)
                    .startDate(startDate)
                    .endDate(endDate)
                    .room(room)
                    .user(user)
                    .build();
            reservationRepository.save(reservation);
            log.info("Created reservation");

        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
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
        return reservationRepository.findReservationsForCEO(userId);
    }

    @Override
    public List<Reservation> listReservationsByStatusForCEO(Long userId, String status) {
        ReservationStatus reservationStatus = ReservationStatus.valueOf(status);
        List<Reservation> reservationsByStatusForCEO = reservationRepository.findReservationsByStatusForCEO(userId, reservationStatus);
        return reservationsByStatusForCEO;
    }

    private boolean validateRoom(List<Reservation> reservations, LocalDate startDate, LocalDate endDate){
        log.info("validateRoom method");
        Optional<Reservation> optionalReservation = reservations.stream().filter(f -> !(f.getEndDate().isBefore(startDate) && !(f.getStartDate().isAfter(endDate)))).findFirst();
        if (optionalReservation.isEmpty())
            return true;
        log.info("Returning false!!");
        return false;
    }

}
