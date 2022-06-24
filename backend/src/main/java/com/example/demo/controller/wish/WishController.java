package com.example.demo.controller.wish;


import com.example.demo.service.wish.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/wish")
public class WishController {
    @Autowired
    private WishService wishService;



    @DeleteMapping("/delete{wishNo}")
    public void wishDelete(@PathVariable("wishNo") Long wishNo){
        log.info("deleteWish() " + wishNo);

        wishService.deleteWish(wishNo);
    }
}
