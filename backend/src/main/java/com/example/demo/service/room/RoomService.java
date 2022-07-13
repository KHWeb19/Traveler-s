package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.room.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RoomService {
    public void register (RoomRequest roomRequest, List<MultipartFile> files) throws Exception;
    public List<HotelResponse> findHotel(String email);
    public List<RoomResponse> findRoomList(Long hotelNo);
    public RoomResponse bmRoomRead(Integer roomNo);
    public Long bmRoomModify(RoomRequest roomRequest, List<MultipartFile> files, Integer roomNo, List<String> oldFiles);
    public void bmRoomRemove(Integer roomNo);
    public void bmRoomsRemove(List<Long> roomNo);

    //----------------------------------------------------------
    public List<RoomResponse> findMRoomList(KeyWordRequest keyWordRequest);
}

