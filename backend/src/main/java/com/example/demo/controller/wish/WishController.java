package com.example.demo.controller.wish;


import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.wish.Wish;
import com.example.demo.service.wish.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/wish")
public class WishController {
    @Autowired
    private WishService wishService;



    @PostMapping("/{hotelNo}/save")
    public boolean addWish(@Validated @RequestBody Wish wish  , @PathVariable("hotelNo") Long hotelNo){
        log.info ("wish()" + wish + hotelNo );
        return wishService.addWish(wish, hotelNo);
    }



    @DeleteMapping("/delete{wishNo}")
    public void wishDelete(@PathVariable("wishNo") Long wishNo){
        log.info("deleteWish() " + wishNo);

        wishService.deleteWish(wishNo);
    }
}
