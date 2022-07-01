package com.example.demo.service.search;

import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.dto.hotel.HotelResponse.hotelBuilder;

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<HotelResponse> tagSearchList(String word) {
        List<Hotel> findSearchList = hotelRepository.findByHotelInfoContainingWithUser(word);

        log.info("findSearchList : ");

        return hotelBuilder(findSearchList);
    }

    @Override
    public List<HotelResponse> commonSearchList(KeyWordRequest keyWordRequest) {

        LocalDate date = LocalDate.parse(keyWordRequest.getDates().get(0));
        log.info("date : " + date);
        List<Hotel> hotelList = hotelRepository.Search(keyWordRequest.getCity(), keyWordRequest.getPersonnel(),date);

        log.info("search :" + hotelList);


        return hotelBuilder(hotelList);
    }

}
