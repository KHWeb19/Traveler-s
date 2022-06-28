package com.example.demo.service.wish;


import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.wish.Wish;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.wish.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class WishServiceImpl implements WishService{

    @Autowired
    private WishRepository wishRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public boolean addWish(User user , Long hotelNo) {
        Wish wish = new Wish();
        Optional<Hotel> findBoard =hotelRepository.findById(hotelNo);
        log.info("getHotelNo: " + hotelNo);


        if (wishRepository.findHotelNoByIdAndHotelHotelNo(user.getId(), hotelNo).isEmpty()) {
            wish.setHotel(findBoard.get());
            wish.setUser(user);
            wishRepository.save(wish);
            return true;
        }
        return false;
    }



    @Override
    public void deleteWish(Long wishNo) {
        wishRepository.deleteById(wishNo);
    }

    @Override
    public List<Hotel> findHotel(Long id) {
        List<Wish> wish = wishRepository.findByUserNo(id);

        List<Hotel> hotelList = new ArrayList<>();

        for(Wish wish2 : wish){
            hotelList.add(wish2.getHotel());
        }
        log.info("hotelList : " + hotelList);
        return hotelList;
    }
}
