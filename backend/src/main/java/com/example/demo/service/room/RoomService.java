package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponseDTO;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.entity.room.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RoomService {
    public void register (RoomRequest roomRequest, List<MultipartFile> files) throws Exception;
    public List<RoomResponse> findHotel(String email);
    public List<Room> findRoomList(Long hotelNo);
    public Room bmRoomRead(Integer roomNo);
    public Room bmRoomModify(Room Room, List<MultipartFile> files);
    public void bmRoomRemove(Integer roomNo);
    public void bmRoomsRemove(List<Long> roomNo);

    //----------------------------------------------------------
    public List<RoomResponseDTO> findMRoomList(Long hotelNo); //주석
}

