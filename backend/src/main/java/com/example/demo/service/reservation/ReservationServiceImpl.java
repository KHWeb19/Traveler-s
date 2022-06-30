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

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Override
    public void createReservation(Long roomId) {
        log.info("createReservation in serviceImpl");
        Optional<User> optionalUser = userRepository.findByEmail("ceo@gmail.com");
        User user = optionalUser.get();

        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        Room room = optionalRoom.get();

        Reservation reservation = new Reservation(2500L, ReservationStatus.PENDING, user, room);
        reservationRepository.save(reservation);
        log.info("Created reservation");
    }

    @Override
    public List<Reservation> listReservationWithRoomId(Long id) {
        List<Reservation> reservations = reservationRepository.findByRoom_RoomNo(id);
        return reservations;
    }
}
