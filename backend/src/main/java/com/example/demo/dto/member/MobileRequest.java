package com.example.demo.dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MobileRequest {
    private String mobile;

    public MobileRequest(String mobile){
        this.mobile = mobile;
    }
}
