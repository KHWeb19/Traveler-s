package com.example.demo.controller.hotel;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.room.Room;
import com.example.demo.service.member.UserService;
import com.example.demo.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {


    private final RoomService roomService;
    private final UserService userService;

    @PostMapping(value="/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void roomRegister (@Validated @RequestPart(value="roomRequest") RoomRequest roomRequest,
                              @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("roomRegister()" + roomRequest);
        log.info("files :" + files);

        roomService.register(roomRequest, files);
    }

    @GetMapping("/getHotelType")
    public List<HotelResponse> getHotelType(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return roomService.findHotel(email);
    }

    @PostMapping("/bm/list")
    public List<RoomResponse> bmRoomList (@RequestBody RoomRequest roomRequest) {
        log.info("bmRoomList()" + roomRequest.getHotelNo());

        return roomService.findRoomList(roomRequest.getHotelNo());
    }
    
   @GetMapping("/bm/{roomNo}")
    public RoomResponse bmHotelRead (
            @PathVariable("roomNo") Integer roomNo) {
        log.info("business member Room Read()" + roomNo);
        return roomService.bmRoomRead(roomNo);
    }

    @PutMapping("/bm/{roomNo}")
    public RoomResponse bmRoomModify (
            @PathVariable("roomNo") Integer roomNo,
            @Validated @RequestPart(value="roomRequest") RoomRequest roomRequest,
            @RequestPart(value = "files") List<MultipartFile> files,
            @RequestPart(value = "oldFiles") List<String> oldFiles) {
        log.info("business member Hotel Modify(): " + roomRequest);
        log.info("files :" + files);
        log.info(oldFiles.toString());

        return roomService.bmRoomModify(roomRequest, files , roomNo, oldFiles);
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

    //---------------------------------------------------------------------------------------------------------------

    @PostMapping("/mem/list")
    public List<RoomResponse> mRoomList (@RequestBody KeyWordRequest keyWordRequest) { //주석
        log.info("hotel's roomList" + keyWordRequest);

        return roomService.findMRoomList(keyWordRequest);
    }

}