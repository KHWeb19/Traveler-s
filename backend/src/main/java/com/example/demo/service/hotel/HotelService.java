package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.entity.hotel.Hotel;

import java.util.List;

public interface HotelService {
    public void register (HotelRequest hotelRequest);
    public List<Hotel> list ();
    public Hotel read (Integer hotelNo);
    public void modify (Hotel hotel);
    public void remove (Integer hotelNo);
}
