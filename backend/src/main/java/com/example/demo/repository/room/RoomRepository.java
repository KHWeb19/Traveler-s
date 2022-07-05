package com.example.demo.repository.room;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.reservation.ReservationStatus;
import com.example.demo.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select m from Room m join m.hotel tb where tb.hotelNo = :hotelNo")
    List<Room> findAllRoomByHotelNo(Long hotelNo);

    @Query("select h from Room h join fetch h.hotel where h.roomNo = :roomNo")
    Optional<Room> findByWithHotel(Long roomNo);

    @Query("select r from Room r join fetch r.hotel h join r.reservations b where h.hotelNo = :hotelNo " +
            "and r.personnel >= :personnel and b.startDate <= :date and b.endDate > :date and b.status != :status")
    List<Room> findByIdAndDateAndPersonnel(Long hotelNo, int personnel, LocalDate date, ReservationStatus status);

    @Query("select r from Room r join fetch r.hotel h join r.reservations b where h.totalAddress like concat('%',:address,'%') " +
            "and r.personnel >= :personnel and b.startDate <= :date and b.endDate > :date " +
            "and b.status != :status ")
    List<Room> Search(String address, int personnel, LocalDate date, ReservationStatus status);
}

