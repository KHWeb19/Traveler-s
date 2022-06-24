package com.example.demo.repository.wish;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.wish.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, Long> {

    Optional<Wish> findByHotelAndUser(Hotel hotel, User user);

}
