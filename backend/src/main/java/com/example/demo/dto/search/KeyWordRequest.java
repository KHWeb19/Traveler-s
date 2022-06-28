package com.example.demo.dto.search;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class KeyWordRequest {
    private String word;
    private List<String> dates;
    private int personnel;
    private String city;

    public KeyWordRequest(String word){
        this.word = word;
    }

    public KeyWordRequest(List<String> dates, int personnel, String city){
        this.dates = dates;
        this.personnel = personnel;
        this.city = city;
    }
}
