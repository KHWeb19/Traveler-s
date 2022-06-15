package com.example.demo.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class MyPageResponse {
    private String name;
    private String email;

    public MyPageResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
