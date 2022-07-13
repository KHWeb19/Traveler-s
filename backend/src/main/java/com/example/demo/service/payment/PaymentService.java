package com.example.demo.service.payment;

import com.example.demo.dto.payment.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {
    void createPayment(PaymentRequest paymentRequest) throws JsonProcessingException;
    void cancelPayment(PaymentRequest paymentRequest) throws JsonProcessingException;
    void requestRefund(String id) throws JsonProcessingException;
}
