package com.example.demo.service.search;

import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

        Set<Hotel> hotelList = hotelRepository.findByTotalAddressContainingWithRoom(keyWordRequest.getCity(),keyWordRequest.getPersonnel());

        List<Room> roomList = roomRepository.Search(keyWordRequest.getCity() , keyWordRequest.getPersonnel(), date);
        //호텔에서 이 룸 제거 해야함 어케하노
        //호텔 리스트에서 룸 뺴내서 해야되나??
        List<Hotel> hotels = new ArrayList<>();
        //인생...
        //일단 예약하려는 날짜에 예약이 들어있으면 if문으로 들어감
        if(!roomList.isEmpty()) {
            log.info("this");
            //룸에 매핑된 hotelNo과 hotel의 hotelNo이 같으면 호텔에서 그 room제거
            for (Hotel hotel : hotelList) {
                for (Room room : roomList) {
                    if (hotel.getHotelNo() == room.getHotel().getHotelNo()) {
                        hotel.removeRoomFromHotel(room);
                    }
                }
                //room 다 돌고 hotel 저장 , room 없으면 hotel 저장 안함
                if(hotel.getRooms().size() > 0) {
                    hotels.add(hotel);
                }
            }
            //예약 들어 있는 room제거 후에 hotelReponse builder
            return hotelBuilder(hotels);
        }

        //예약 날짜에 걸리는 room없으면 그냥 지역으로 구한 hotel과 room builder
        return hotelBuilder(hotelList);
    }

}
