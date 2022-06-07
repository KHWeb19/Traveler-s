package com.example.demo.service.Hotel;

import com.example.demo.entity.Hotel.Hotel;

import java.util.List;

public interface HotelService {
    public void register (Hotel hotel);
    public List<Hotel> list ();
    public Hotel read (Integer hotelNo);
    public void modify (Hotel hotel);
    public void remove (Integer hotelNo);
}
