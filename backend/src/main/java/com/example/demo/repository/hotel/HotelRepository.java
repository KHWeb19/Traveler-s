package com.example.demo.repository.hotel;

import com.example.demo.entity.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Transactional
    @Query(value = "select * from hotel order by rand() limit ?1", nativeQuery = true)
    public List<Hotel> randomPick(Integer randNum);


    @Query(value = "select * from hotel m where m.writer = :writer", nativeQuery = true)
    Optional<Hotel> findByWriter(@Param("writer") String writer);
}

