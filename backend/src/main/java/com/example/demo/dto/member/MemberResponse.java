package com.example.demo.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberResponse {
    private String name;
    private String email;

    /*public MemberResponse(String name, String email){
        this.email = email;
        this.name  = name;
    }*/

}
