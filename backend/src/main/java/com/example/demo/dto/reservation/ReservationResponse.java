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
    private String email;
    private String mobile;
    private Long userNo;
    private String roomType;


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
    public static ReservationResponse reservationResponseBuilderForCeo(Reservation reservation){
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
                .email(reservation.getUser().getEmail())
                .mobile(reservation.getUser().getMobile())
                .userNo(reservation.getUser().getId())
                .roomType(reservation.getRoom().getRoomType())
                .build();
    }
    public static List<ReservationResponse> reservationResponseListBuilderForCeo(List<Reservation> reservations) {
        return reservations.stream().map(r -> reservationResponseBuilderForCeo(r)).collect(Collectors.toList());
    }
}
