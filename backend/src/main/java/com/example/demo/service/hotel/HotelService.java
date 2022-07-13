package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.entity.member.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HotelService {
    public void register (HotelRequest hotelRequest, List<MultipartFile> files, User user) throws Exception;
    public HotelResponse bmHotelRead (Integer hotelNo);
    public List<HotelResponse> bmHotelList ();
    public HotelResponse bmHotelModify (HotelRequest hotelRequest, List<MultipartFile> files, Integer hotelNo, List<String> oldFiles);
    public void bmHotelRemove (Integer hotelNo);
    public void bmHotelsRemove(List<Long> hotelNo);

    // -------------------------------------------------------------------------------------------------------------

    public List<HotelResponse> random ();
    public HotelResponse mRead (Integer hotelNo);

}