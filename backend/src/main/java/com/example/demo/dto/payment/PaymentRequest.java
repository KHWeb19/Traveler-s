package com.example.demo.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String imp_uid;
    private String merchant_uid;


    private String imp_key;
    private String imp_secret;
}
