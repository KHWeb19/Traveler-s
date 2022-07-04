package com.example.demo.repository.hotel;

import com.example.demo.entity.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "select * from Hotel order by hotel_no desc limit :randNum", nativeQuery = true)
    public List<Hotel> randomPick(Integer randNum);

    @Query("select h from Hotel h join fetch h.user where h.hotelInfo like concat('%',:word,'%')")
    List<Hotel> findByHotelInfoContainingWithUser(String word);

    @Query("select h from Hotel h join fetch h.user where h.hotelNo = :hotelNo")
    Optional<Hotel> findByIdWithUser(Long hotelNo);

    @Query("select h from Hotel h join fetch h.rooms where h.hotelNo = :hotelNo")
    Optional<Hotel> findByIdWithRooms(Long hotelNo);

    @Query("select h from Hotel h join fetch h.rooms r join fetch h.user where h.totalAddress like concat('%',:city,'%')" +
            "and r.personnel >= :personnel")
    Set<Hotel> findByTotalAddressContainingWithRoom(String city, int personnel);

}


