package com.example.demo.controller.hotel;

import com.example.demo.entity.Hotel.Hotel;
import com.example.demo.service.hotel.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


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



}
