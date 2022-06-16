package com.example.demo.repository.hotel;

import com.example.demo.entity.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Transactional

}
