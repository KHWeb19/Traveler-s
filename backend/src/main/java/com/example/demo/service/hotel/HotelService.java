package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.entity.hotel.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface HotelService {
    public void register (Hotel hotel, List<MultipartFile> files) throws Exception;
    //public List<Hotel> list ();
    public List<Hotel> random ();
    public Hotel mRead (Integer hotelNo);
    public void modify (Hotel hotel);
    public void remove (Integer hotelNo);
}
