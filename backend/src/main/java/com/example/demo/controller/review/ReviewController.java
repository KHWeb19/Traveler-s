package com.example.demo.controller.review;

import com.example.demo.entity.review.Review;
import com.example.demo.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
/**
 @PostMapping("/register/{hotelNo}")
 public void reviewRegister(@Validated Review review, @PathVariable("hotelNo") Long hotelNo){
 log.info("reviewRegister()" );
 reviewService.register(review, hotelNo);
 }
 */

    /**
     @GetMapping("/list/{hotelNo}")
     public void List<Review> list(@PathVariable("hotelNo") Long hotelNo{
     log.info("list()");

     return reviewService.list(hotelNo);

     }
     */

    @PutMapping("/update/{reviewNo}")
    public Review jpaReviewModify (
            @PathVariable("reviewNo") Integer boardNo,
            @RequestBody Review review) {
        log.info("jpaReviewModify(): " + review);

        review.setReviewNo(Long.valueOf(boardNo));
        reviewService.modify(review);

        return review;
    }

    @DeleteMapping("/delete/{reviewNo}")
    public void jpaReviewRemove (
            @PathVariable("reviewNo") Long reviewNo) {
        log.info("jpaReviewRemove()");

        reviewService.remove(reviewNo);
    }
}
