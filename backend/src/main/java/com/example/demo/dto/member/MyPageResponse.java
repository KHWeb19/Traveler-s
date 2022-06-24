package com.example.demo.dto.member;

import com.example.demo.entity.member.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
public class MyPageResponse {
    private String name;
    private String email;
    private String profile_path;
    private List<Role> roles;

    public MyPageResponse(String name, String email, String profile_path, List<Role> roles) {
        this.name = name;
        this.email = email;
        this.profile_path = profile_path;
        this.roles = roles;
   }
}
