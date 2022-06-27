package com.example.demo.controller.hotel;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.dto.member.MyPageResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.service.hotel.HotelService;
import com.example.demo.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {


    private final RoomService roomService;

    @PostMapping(value="/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void roomRegister (@Validated @RequestPart(value="roomRequest") RoomRequest roomRequest,
                              @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("roomRegister()" + roomRequest);
        log.info("files :" + files);

        roomService.register(roomRequest, files);
    }

    @GetMapping("/getHotelType")
    public List<RoomResponse> getHotelType(){
        String writer = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return roomService.findHotel(writer);
    }

    @PostMapping("/bm/list")
    public List<Room> bmRoomList (@RequestBody RoomRequest roomRequest) {
        log.info("bmRoomList()" + roomRequest.getHotelNo());

        return roomService.findRoomList(roomRequest.getHotelNo());
    }

    @GetMapping("/bm/{roomNo}")
    public Room bmHotelRead (
            @PathVariable("roomNo") Integer roomNo) {
        log.info("business member Room Read()" + roomNo);
        return roomService.bmRoomRead(roomNo);
    }

    @PutMapping("/bm/{roomNo}")
    public Room bmRoomModify (
            @PathVariable("roomNo") Integer roomNo,
            @Validated @RequestPart(value="roomRequest") Room room,
            @RequestPart(value = "files") List<MultipartFile> files) {
        log.info("business member Hotel Modify(): " + room);
        log.info("files :" + files);

        room.setRoomNo(Long.valueOf(roomNo));
        return roomService.bmRoomModify(room, files);
    }

    @DeleteMapping("/bm/{roomNo}")
    public void bmRoomRemove (
            @PathVariable("roomNo") Integer roomNo) {
        log.info("roomRemove()");

        roomService.bmRoomRemove(roomNo);
    }

    @PostMapping("/bm/deleteRooms")
    public void deleteRooms (
            @RequestBody List<Long> rooms) {
        log.info("roomRemove()" + rooms);

        roomService.bmRoomsRemove(rooms);
    }



}
