package com.example.demo.dto.reservation;

import lombok.Getter;

@Getter
public class ReservationRequest {
    private int roomId;
    private String startDate;
    private String endDate;
    private String status;
}
