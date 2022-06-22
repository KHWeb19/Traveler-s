package com.example.demo.repository.room;

import com.example.demo.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {

}

