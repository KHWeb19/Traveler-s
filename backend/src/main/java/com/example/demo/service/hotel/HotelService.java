package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelResponseWithWriter;
import com.example.demo.entity.hotel.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HotelService {
    public void register (Hotel hotel, List<MultipartFile> files) throws Exception;
    public Hotel bmHotelRead (Integer hotelNo);
    public List<Hotel> bmHotelList ();
    public void bmhotelModify (Hotel hotel);
    public void bmhotelRemove (Integer hotelNo);

    // -------------------------------------------------------------------------------------------------------------

    public List<Hotel> random ();
    public HotelResponseWithWriter mRead (Integer hotelNo);

}