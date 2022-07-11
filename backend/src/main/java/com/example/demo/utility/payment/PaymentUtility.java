package com.example.demo.utility.payment;

import com.example.demo.dto.payment.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Slf4j
@Component
public class PaymentUtility {

    public String createAccessToken() throws JsonProcessingException {
        String tokenUrl = "https://api.iamport.kr/users/getToken";
        String impkey = "9019040619488350";
        String impSecret = "d11a9c5d87810456677498bafc19e396bc6f886f67764acd0747702f93fb16bd3b35ff86447dbcde";

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .imp_key(impkey)
                .imp_secret(impSecret)
                .build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, paymentRequest, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        String access_token = rootNode.get("response").get("access_token").asText();

        return access_token;
    }

    public HashMap<String, String> getPaymentInformation(String accessToken, PaymentRequest paymentRequest) throws JsonProcessingException {

        String checkUrl = "https://api.iamport.kr/payments/" + paymentRequest.getImp_uid();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(checkUrl, HttpMethod.GET, request, String.class);

        log.info(response.getBody().toString());
        return getMerchantUidAndAmount(response.getBody());

    }

    public HashMap<String, String> requestRefund(String accessToken, PaymentRequest paymentRequest) throws JsonProcessingException {

        String refundUrl = "https://api.iamport.kr/payments/cancel";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        HttpEntity<PaymentRequest> request = new HttpEntity(paymentRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(refundUrl, HttpMethod.POST, request, String.class);

        log.info(response.getBody());

        return getMerchantUidAndAmount(response.getBody());
    }


    private HashMap<String, String> getMerchantUidAndAmount(String responseBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(responseBody);
        JsonNode responseNode = rootNode.get("response");
        String amount = responseNode.get("amount").asText();
        String merchant_uid = responseNode.get("merchant_uid").asText().substring(36);
        log.info("merchant uid: {}", merchant_uid);
        HashMap<String, String> map = new HashMap<>();
        map.put("amount", amount);
        map.put("id", merchant_uid);

        return map;
    }
}
