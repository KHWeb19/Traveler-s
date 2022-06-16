package com.example.demo.repository.hotel;

import com.example.demo.entity.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
  /*
    @Transactional
    @Query(value = "select * from hotel order by rand() limit randNum", nativeQuery = true)
    public List<Hotel> randomPick(Integer randNum);
   */
}
