package com.example.demo.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class MyPageResponse {
    private String name;
    private String email;
    private String profile_path;

    public MyPageResponse(String name, String email, String profile_path) {
        this.name = name;
        this.email = email;
        this.profile_path = profile_path;
    }
}