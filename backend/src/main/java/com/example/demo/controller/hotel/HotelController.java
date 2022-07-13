package com.example.demo.controller.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.entity.member.User;
import com.example.demo.service.hotel.HotelService;
import com.example.demo.service.member.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public void hotelRegister (@Validated @RequestPart(value="hotel") HotelRequest hotelRequest,
                               @RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        log.info("hotelRegister()" + hotelRequest);

        log.info("files :" + files);

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmailWithHotels(email).get();

        hotelService.register(hotelRequest, files, user);

    }

    //사업자 매뉴얼 페이지 호텔 목록
    @GetMapping("/bm/list")
    public List<HotelResponse> bmHotelList () {
        log.info("bmHotelList()");

        return hotelService.bmHotelList();
    }

    //사업자 매뉴얼 페이지 호텔 읽기
    @GetMapping("/bm/{hotelNo}")
    public HotelResponse bmHotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("business member Hotel Read()");
        return hotelService.bmHotelRead(hotelNo);
    }

    //사업자 매뉴얼 페이지 호텔 수정
    @PutMapping("/bm/{hotelNo}")
    public HotelResponse bmHotelModify (
            @PathVariable("hotelNo") Integer hotelNo,
            @Validated @RequestPart(value="hotel") HotelRequest hotelRequest,
            @RequestPart(value = "files") List<MultipartFile> files,
            @RequestPart(value = "oldFiles") List<String> oldFiles) {
        log.info("business member Hotel Modify(): " + hotelRequest);
        log.info("files :" + files);

        return hotelService.bmHotelModify(hotelRequest, files , hotelNo, oldFiles);
    }

    //사업자 매뉴얼 페이지 호텔 삭제
    @DeleteMapping("/bm/{hotelNo}")
    public void bmHotelRemove (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("hotelRemove()");

        hotelService.bmHotelRemove(hotelNo);
    }

    @PostMapping("/bm/deleteHotels")
    public void deleteHotels (
            @RequestBody List<Long> hotels) {
        log.info("roomRemove()" + hotels);

        hotelService.bmHotelsRemove(hotels);
    }

// ---------------------------------------------------------------------------------------------------------------------


    @GetMapping("/mainList")
    public List<HotelResponse> hotelMainList () { //메인 페이지에서 호텔 list 불러오기
        log.info("HotelRandom()");

        return hotelService.random(); //randHotel을 추리는 작업을 hotelService안의 random이 실행한다.
    }

    @GetMapping("/mRead/{hotelNo}") //고객 페이지쪽 호텔 상세보기
    public HotelResponse mHotelRead (
            @PathVariable("hotelNo") Integer hotelNo) {
        log.info("memberHotelRead()");

        return hotelService.mRead(hotelNo);
    }

    //search 넣기

}