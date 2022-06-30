package com.example.demo.controller.wish;


import com.example.demo.dto.wish.WishResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.wish.Wish;
import com.example.demo.service.member.UserService;
import com.example.demo.service.wish.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/wish")
public class WishController {
    @Autowired
    private WishService wishService;

    @Autowired
    private UserService userService;


    @PostMapping("/{hotelNo}/save")
    public boolean addWish(@PathVariable("hotelNo") Long hotelNo){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();
        log.info ("wish()" +  hotelNo );
        return wishService.addWish(user, hotelNo);
    }



    @DeleteMapping("/delete{wishNo}")
    public void wishDelete(@PathVariable("wishNo") Long wishNo){
        log.info("deleteWish() " + wishNo);

        wishService.deleteWish(wishNo);
    }

    @GetMapping("/HotelList")
    public List<WishResponse> listHotel(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();
        log.info("WishResponse " );
        return wishService.findWish(user.getId());
    }


}
