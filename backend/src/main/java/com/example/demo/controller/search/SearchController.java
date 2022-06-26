package com.example.demo.controller.search;

import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.service.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final HotelService hotelService;

    @PostMapping("/tagSearch")
    public List<Hotel> tagSearch (@RequestBody KeyWordRequest keyWord) {
        log.info("tagSearch()");
        String word = keyWord.getKeyWord();


        return hotelService.searchList(word);
    }
}
