package com.example.demo.service.search;

import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;

import java.util.List;

public interface SearchService {
    public List<Hotel> tagSearchList(String word);
    public List<Hotel> commonSearchList(KeyWordRequest keyWordRequest);
}
