package com.example.demo.repository.wish;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.wish.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, Long> {

    Optional<Wish> findHotelNoByIdAndHotelHotelNo(Long id, Long  hotelNo);




}
