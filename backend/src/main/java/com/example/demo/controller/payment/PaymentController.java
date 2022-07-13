package com.example.demo.controller.payment;

import com.example.demo.dto.payment.PaymentRequest;
import com.example.demo.service.payment.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/complete")
    public ResponseEntity<?> paymentComplete(@RequestBody PaymentRequest paymentRequest) throws JsonProcessingException {

        paymentService.createPayment(paymentRequest);

        return ResponseEntity.ok().build();
    }

    // 결제 검증 실패시 환불 요청
    @PostMapping("/cancel")
    public ResponseEntity<?> cancelPayment(@RequestBody PaymentRequest paymentRequest) throws JsonProcessingException {
        paymentService.cancelPayment(paymentRequest);

        return ResponseEntity.ok().build();
    }

    // 직접 환불요청
    @PostMapping("/requestRefund/{id}")
    public ResponseEntity<?> requestRefund(@PathVariable(value="id") String id) throws JsonProcessingException {
        log.info("Requesting Refund for Reservation Id: {}", id);
        paymentService.requestRefund(id);

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<?> jsonProcessingException(){
        log.info("Handling Json Processing Exception");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(){
        log.info("Handling No Such Element Exception");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> illegalStateException(){
        log.info("Handling Illegal State");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
