package com.example.demo.controller.hotel;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.example.demo.service.hotel.HotelService;
import com.example.demo.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(value="/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void roomRegister (@Validated @RequestPart(value="roomRequest") RoomRequest roomRequest,
                              @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("roomRegister()" + roomRequest);
        log.info("files :" + files);

        String writer = roomRequest.getWriter();

        roomService.register(roomRequest, files);
    }

}
