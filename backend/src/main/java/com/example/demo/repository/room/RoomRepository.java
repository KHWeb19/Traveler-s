package com.example.demo.repository.room;

import com.example.demo.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select m from Room m join m.hotel tb where tb.hotelNo = :hotelNo")
    List<Room> findAllRoomByHotelNo(Long hotelNo);

    @Query("select h from Room h join fetch h.hotel where h.roomNo = :roomNo")
    Optional<Room> findByWithHotel(Long roomNo);

}

