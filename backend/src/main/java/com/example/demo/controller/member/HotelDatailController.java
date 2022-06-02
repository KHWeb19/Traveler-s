package com.example.demo.controller.member;

import com.example.demo.entity.Hotel.Hotel;
import com.example.demo.entity.Room.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotelDetail")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HotelDatailController {

    //현재 작성된 내용 사실은 각각 Hotel과 Room Controller에 들어가야 한다고 생각함.
    //P1작성 파트인데 내가 담당하는 부분이 아니기 때문에 충돌 발생을 우려하여 예비로 이곳에 작성
    //차후 합치면 될 것 같음.


    /*
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/hotelList")
    public List<Hotel> hotelList () {
        log.info("HotelList ()");

        return hotelService.list();
    }

    @GetMapping("/{hotelNo}")
    public Hotel hotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("hotelRead()");

        return hotelService.read(hotelNo);
    }

    @GetMapping("/roomList")
    public List<Room> roomList () {
        log.info("RoomList ()");

        return roomService.list();
    }
     */

}
