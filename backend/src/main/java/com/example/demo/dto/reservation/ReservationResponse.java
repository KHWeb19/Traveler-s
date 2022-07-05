package com.example.demo.dto.reservation;

import com.example.demo.entity.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {
    private Long id;
    private Long price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private String username;
    private Long roomId;
    private String hotelName;
    private int personnel;

    public static List<ReservationResponse> reservationResponseListBuilder(List<Reservation> reservations) {
        return reservations.stream().map(r -> reservationResponseBuilder(r)).collect(Collectors.toList());
    }

    public static ReservationResponse reservationResponseBuilder(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .price(reservation.getPrice())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(String.valueOf(reservation.getStatus()))
                .build();
    }

    public static ReservationResponse reservationResponseBuilderWithUser(Reservation reservation){
        return ReservationResponse.builder()
                .id(reservation.getId())
                .username(reservation.getUser().getName())
                .roomId(reservation.getRoom().getRoomNo())
                .personnel(reservation.getRoom().getPersonnel())
                .hotelName(reservation.getRoom().getHotel().getHotelName())
                .price(reservation.getPrice())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .status(String.valueOf(reservation.getStatus()))
                .build();
    }
}
