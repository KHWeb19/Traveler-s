package com.example.demo.service.wish;

import com.example.demo.dto.wish.WishResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.wish.Wish;

import java.util.List;

public interface WishService {


    public boolean addWish(User user, Integer hotelNo);

    public boolean deleteWish(User user,Integer wishNo);

    public List<WishResponse> findWish(Long id);

    Wish wishRead(Long wishNo);
}
