package com.example.demo.service.review;

import com.example.demo.entity.review.Review;
import com.example.demo.repository.review.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReviewServiceImpl  implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;

    /**
     @Autowired
     HotelRepository hotelRepository;

     */

/**
 @Override
 public void register(Review review, Long hotelNo){
 Optional<Hotel> findProduct = hotelRepository.findById(hotelNo);

 review.setHotel(findProduct.get());
 reviewRepository.save(review);

 }
 */
    /**
     @Override
     public List<Review> list(Long hotelNo) {
     // Hotel hotel = hotelRepository.finById(hotelNo).get();
     return reviewRepository.findReviewByHotelNo(hotel);
     }
     */


    @Override
    public void modify(Review review) { reviewRepository.save(review);

    }

    @Override
    public void remove(Long reviewNo) { reviewRepository.deleteById(Long.valueOf(reviewNo));

    }


}
