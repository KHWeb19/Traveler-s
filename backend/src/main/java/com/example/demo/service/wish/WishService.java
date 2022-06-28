package com.example.demo.service.wish;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.wish.Wish;

import java.util.List;

public interface WishService {


    boolean addWish(Wish wish, Long hotelNo);

    void deleteWish(Long wishNo);
}
