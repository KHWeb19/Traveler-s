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

import javax.swing.text.html.Option;
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
    public boolean addWish(Wish wish , Long hotelNo) {

        Optional<Hotel> findBoard =hotelRepository.findById(hotelNo);
        log.info("getBoardNo: " + wish);

        wish.setHotel(findBoard.get());

        if (wishRepository.findHotelNoByIdAndHotelHotelNo(wish.getId(), hotelNo).isEmpty()) {
            wishRepository.save(wish);
            return true;
        }
        return false;
    }



    @Override
    public void deleteWish(Long wishNo) {
        wishRepository.deleteById(wishNo);
    }
}
