package com.example.demo.service.review;

import com.example.demo.entity.review.Review;

public interface ReviewService {
        public void register (Review review);



        public void modify (Review review);
        public void remove (Integer reviewNo);

}
