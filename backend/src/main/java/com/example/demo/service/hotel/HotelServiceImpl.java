package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.repository.hotel.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository repository;

    @Override
    public void register(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setHotelInfo(hotelRequest.getHotelInfo());
        repository.save(hotel);
    }

    @Override
    public List<Hotel> list() {
        log.info("HotelServiceIMPL list");
        return repository.findAll(Sort.by(Sort.Direction.DESC, "hotelNo"));
    }

    @Override
    public Hotel read(Integer hotelNo) {
        Optional<Hotel> maybeReadBoard = repository.findById(Long.valueOf(hotelNo));
        //Optional: null일 수도 있는 객체를 감싸는 일종의 Wrapper 클래스
        /*
        optional 변수 내부에는 null이 아닌 T 객체가 있을 수도 있고 null이 있을 수도 있습니다.
        따라서, Optional 클래스는 여러 가지 API를 제공하여 null일 수도 있는 객체를 다룰 수 있도록 돕습니다
         */
        log.info("HotelServiceIMPL readOK");
        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();

    }

    @Override
    public void modify(Hotel hotel) {
        repository.save(hotel);
    }

    @Override
    public void remove(Integer hotelNo) {
        repository.deleteById(Long.valueOf(hotelNo));
    }
}
