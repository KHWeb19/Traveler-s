package com.example.demo.service.wish;


import com.example.demo.dto.wish.WishResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.wish.Wish;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.wish.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class WishServiceImpl implements WishService {

    @Autowired
    private WishRepository wishRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addWish(User user, Long hotelNo) {
        Wish wish = new Wish();
        Optional<Hotel> findBoard = hotelRepository.findById(hotelNo);
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

    @Transactional
    @Override
    public List<WishResponse> findWish(Long id) {
        Optional<User> user = userRepository.findByIDWithWishAndWithHotel(id);

        List<WishResponse> wishList = new ArrayList<>();
        WishResponse wishResponse;
        log.info("wish :" + user.get().getWish());
        for (Wish wish2 : user.get().getWish()) {
            wishResponse = new WishResponse(wish2.getHotel().getHotelName(), wish2.getHotel().getTotalAddress());
            wishList.add(wishResponse);
        }
        log.info("wishList : " + wishList);
        return wishList;
    }

    @Override
    public Wish wishRead(Long wishNo) {
        Optional<Wish> maybeReadWish = wishRepository.findById(wishNo);
        log.info("Wishread : " + maybeReadWish);
        if (maybeReadWish.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadWish.get();
    }

}