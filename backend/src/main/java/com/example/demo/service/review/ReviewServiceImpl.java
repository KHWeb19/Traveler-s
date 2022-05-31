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

    @Override
    public void register(Review review) { reviewRepository.save(review);

    }



    @Override
    public void modify(Review review) { reviewRepository.save(review);

    }

    @Override
    public void remove(Integer reviewNo) { reviewRepository.deleteById(Long.valueOf(reviewNo));

    }


}