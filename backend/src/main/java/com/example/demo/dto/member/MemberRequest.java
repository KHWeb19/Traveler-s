package com.example.demo.dto.member;

import com.example.demo.entity.member.Role;
import lombok.Data;

@Data
public class MemberRequest {
    private String email;
    private String password;
    private String name;
    private String mobile;
    private String role;

    public MemberRequest (String email, String password, String name, String mobile, String role){
        this.email = email;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.role = role;
    }
}
