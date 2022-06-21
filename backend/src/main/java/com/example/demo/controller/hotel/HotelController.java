package com.example.demo.controller.hotel;

import com.example.demo.controller.hotel.response.HotelResponse;
import com.example.demo.dto.hotel.HotelRequest;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.service.hotel.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping(value="/hotelRegister", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void hotelRegister (@Validated @RequestPart(value="hotel") Hotel hotel,
                               @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("hotelRegister()" + hotel);

        log.info("files :" + files);

        hotelService.register(hotel, files);
    }



    @GetMapping("/mainList")
    public List<Hotel> hotelMainList () { //메인 페이지에서 호텔 list 불러오기
        log.info("HotelRandom()");

        List<Hotel> randomHotel = hotelService.random(); //randHotel을 추리는 작업을 hotelService안의 random이 실행한다.
        List<HotelResponse> responses = new ArrayList<>();

        for(Hotel hotel : randomHotel) {
            responses.add(new HotelResponse(
                    hotel.getHotelImgPath1(), hotel.getHotelName(), hotel.getTotalAddress(), hotel.getHotelInfo()
            ));
        }


        return randomHotel;
    }



    //search 넣기

    @GetMapping("/mRead/{hotelNo}") //고객 페이지쪽 호텔 상세보기
    public Hotel mHotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("memberHotelRead()");
        return hotelService.mRead(hotelNo);
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