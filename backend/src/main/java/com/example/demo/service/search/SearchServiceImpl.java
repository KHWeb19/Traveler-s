package com.example.demo.service.search;

import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public List<Hotel> commonSearchList(KeyWordRequest keyWordRequest) {
        //그 도시의 호텔 -> 인원수가 되는 방 -> 날짜가 되는 방
        // 걍 다 구해서 가져와서 중복되는애들을 가져가면 안되나 - ㅅ -
        List<Hotel> hotelList = new ArrayList<>();
        List<Hotel> hotelListByAddress = hotelRepository.findByTotalAddressContaining(keyWordRequest.getCity());

        //인원수가 되는방의 날짜가 되는 방을 또 구해야 되니깐 roomList를 만들어야 되나
        //고게 맞는듯? ㅎㅅㅎ
        for(Hotel hotel : hotelListByAddress){
            for(int i = 0; i < hotel.getRooms().size(); i++){
                if(hotel.getRooms().get(i).getPersonnel() >= keyWordRequest.getPersonnel()){
                    hotelList.add(hotel);
                }
            }
        }


        return hotelList;
    }

}
