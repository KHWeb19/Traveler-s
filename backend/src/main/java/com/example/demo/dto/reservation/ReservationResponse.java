package com.example.demo.dto.reservation;

import com.example.demo.entity.reservation.ReservationStatus;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
public class ReservationResponse {
    private Long id;
    private String roomType;
    private ReservationStatus reservationStatus;
    private Long price;
    private LocalDate startDate;
    private LocalDate endDate;

    public ReservationResponse(Long id, String roomType, ReservationStatus reservationStatus, Long price, LocalDate startDate, LocalDate endDate){
        this.id=id;
        this.roomType=roomType;
        this.reservationStatus=reservationStatus;
        this.price=price;
        this.startDate=startDate;
        this.endDate=endDate;
    }

}
