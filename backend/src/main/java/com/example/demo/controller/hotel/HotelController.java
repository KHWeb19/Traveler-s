package com.example.demo.controller.hotel;

import com.example.demo.controller.hotel.response.HotelResponse;
import com.example.demo.dto.hotel.HotelRequest;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.service.hotel.HotelService;
import com.example.demo.service.member.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private UserService userService;

    //사업자 매뉴얼 페이지 호텔 등록
    @PostMapping(value="/hotelRegister", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void hotelRegister (@Validated @RequestPart(value="hotel") Hotel hotel,
                               @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("hotelRegister()" + hotel);

        log.info("files :" + files);

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmailWithHotels(email).get();

        hotel.addUserToHotel(user);

        hotelService.register(hotel, files);

    }

    //사업자 매뉴얼 페이지 호텔 목록
    @GetMapping("/bm/list")
    public List<Hotel> bmHotelList () {
        log.info("bmHotelList()");

        return hotelService.bmHotelList();
    }

    //사업자 매뉴얼 페이지 호텔 읽기
    @GetMapping("/bm/{hotelNo}")
    public Hotel bmHotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("business member Hotel Read()");
        return hotelService.bmHotelRead(hotelNo);
    }

    //사업자 매뉴얼 페이지 호텔 수정
    @PutMapping("/bm/{hotelNo}")
    public Hotel bmhotelModify (
            @PathVariable("hotelNo") Integer hotelNo,
            @Validated @RequestPart(value="hotel") Hotel hotel,
            @RequestPart(value = "files") List<MultipartFile> files) {
        log.info("business member Hotel Modify(): " + hotel);
        log.info("files :" + files);

        hotel.setHotelNo(Long.valueOf(hotelNo));
        hotelService.bmhotelModify(hotel, files);

        return hotel;
    }

    //사업자 매뉴얼 페이지 호텔 삭제
    @DeleteMapping("/bm/{hotelNo}")
    public void bmhotelRemove (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("hotelRemove()");

        hotelService.bmhotelRemove(hotelNo);
    }

    @PostMapping("/bm/deleteHotels")
    public void deleteHotels (
            @RequestBody List<Long> hotels) {
        log.info("roomRemove()" + hotels);

        hotelService.bmHotelsRemove(hotels);
    }

// ---------------------------------------------------------------------------------------------------------------------


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

    @GetMapping("/mRead/{hotelNo}") //고객 페이지쪽 호텔 상세보기
    public Hotel mHotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("memberHotelRead()");
        return hotelService.mRead(hotelNo);
    }

    //search 넣기

}