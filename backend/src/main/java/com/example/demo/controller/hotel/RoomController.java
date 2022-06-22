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

}
