package com.example.demo.controller.search;

import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.service.hotel.HotelService;
import com.example.demo.service.search.SearchService;
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

    private final SearchService searchService;

    @PostMapping("/tagSearch")
    public List<HotelResponse> tagSearch (@RequestBody KeyWordRequest keyWord) {
        log.info("tagSearch()");

        return searchService.tagSearchList(keyWord.getWord());
    }


    @PostMapping("/commonSearch")
    public List<Hotel> commonSearch (@RequestBody KeyWordRequest keyWord) {
        log.info("commonSearch()" + keyWord);

        return searchService.commonSearchList(keyWord);
    }
}
