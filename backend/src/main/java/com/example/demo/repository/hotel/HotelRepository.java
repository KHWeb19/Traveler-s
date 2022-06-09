package com.example.demo.repository.Hotel;

import com.example.demo.entity.Hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
