package com.example.demo.controller.hotel;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.service.hotel.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotel")
//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/hotelregister")
    public void hotelRegister (@Validated @RequestBody Hotel hotel) {
        log.info("hotelRegister()");

        hotelService.register(hotel);
    }
    @GetMapping("/hotelList")
    public List<Hotel> hotelList () { //메인 페이지에서 호텔 list 불러오기
        log.info("HotelList ()");
        return hotelService.list();
    }

    //search 넣기

    @GetMapping("/{hotelNo}") //호텔 상세보기
    public Hotel hotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("hotelRead()");
        return hotelService.read(hotelNo);
    }

    // modify
    @PutMapping("/{hotelNo}")
    public Hotel hotelModify (
            @PathVariable("hotelNo") Integer hotelNo,
            @RequestBody Hotel hotel) {
        log.info("hotelModify(): " + hotel);

        hotel.setHotelNo(Long.valueOf(hotelNo));
        hotelService.modify(hotel);

        return hotel;
    }

    //remove
    @DeleteMapping("/{hotelNo}")
    public void hotelRemove (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("hotelRemove()");

        hotelService.remove(hotelNo);
    }
}
