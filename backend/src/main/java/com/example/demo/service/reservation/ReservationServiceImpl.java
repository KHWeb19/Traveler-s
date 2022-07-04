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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public void createReservation(Long roomId, LocalDate date) {
        log.info("createReservation in serviceImpl");
        List<Reservation> reservationList = reservationRepository.findByRoom_RoomNo(roomId);

        boolean canMakeReservation = true;

        if (!reservationList.isEmpty()){
            //private method 인자값 room이 enddate가 date값보다 작은 reservation을 갖고있다면 return true
            canMakeReservation = validateRoom(reservationList, date);
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
                    .endDate(date)
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
    public List<Reservation> listReservationWithRoomId(Long id, LocalDate date) {
        List<Reservation> reservations = reservationRepository.findByRoom_RoomNo(id);
        List<Reservation> reservationsWithDate = reservations.stream().filter(f -> f.getEndDate().isBefore(date))
                .collect(Collectors.toList());

        return reservationsWithDate;
    }

    @Transactional
    @Override
    public List<ReservationResponse> reservationList(Long id) {
        Optional<User> user =userRepository.findByIDWithReservation(id);
        List<ReservationResponse> reservationList = new ArrayList<>();
        ReservationResponse reservationResponse;
        log.info("reservation() "+ user.get().getReservations());
        for(Reservation reservation2 : user.get().getReservations()){
            reservationResponse = new ReservationResponse(reservation2.getId(),reservation2.getRoom().getRoomType(),
                   reservation2.getStatus(),reservation2.getPrice(),reservation2.getStartDate(),reservation2.getEndDate() );
            reservationList.add(reservationResponse);
        }
        log.info("reservationList : " + reservationList);
        return reservationList;
    }

    private boolean validateRoom(List<Reservation> reservations, LocalDate localDate){
        log.info("validateRoom method");
        List<Reservation> reservationList = reservations.stream().filter(f -> (f.getEndDate() == null) || f.getEndDate().isBefore(localDate)).collect(Collectors.toList());
        if (reservationList.isEmpty()){
            return false;
        }else {
            log.info("validateRoom method returning true");
            return true;
        }
    }

}
