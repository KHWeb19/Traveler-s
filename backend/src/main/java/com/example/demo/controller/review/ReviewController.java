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
    private ReviewService service;

    @PostMapping("/register")
    public void reviewRegister (@Validated @RequestParam Review review){
        log.info("reviewRegister()");

        service.register(review);
    }

    @PutMapping("/{reviewNo}")
    public Review jpaReviewModify (
            @PathVariable("reviewNo") Integer boardNo,
            @RequestBody Review review) {
        log.info("jpaReviewModify(): " + review);

        review.setReviewNo(Long.valueOf(boardNo));
        service.modify(review);

        return review;
    }

    @DeleteMapping("/{reviewNo}")
    public void jpaReviewRemove (
            @PathVariable("reviewNo") Integer reviewNo) {
        log.info("jpaReviewRemove()");

        service.remove(reviewNo);
    }
}

