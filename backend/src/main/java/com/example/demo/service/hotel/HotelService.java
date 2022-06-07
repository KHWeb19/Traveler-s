package com.example.demo.service.hotel;

import com.example.demo.entity.Hotel.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> list ();
    public Hotel read (Integer hotelNo);
}
