package com.example.demo.service.room;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RoomService {
    public void register (Room room, List<MultipartFile> files) throws Exception;
}

