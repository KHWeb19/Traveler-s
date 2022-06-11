package com.example.demo.service.review;

import com.example.demo.entity.review.Review;

public interface ReviewService {
        //  public void register (Review review, Long hotelNo);


        //public List<Review> list  (Long hotelNo);

        public void modify (Review review);
        public void remove (Long reviewNo);
}
