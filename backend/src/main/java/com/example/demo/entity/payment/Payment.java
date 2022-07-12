package com.example.demo.entity.payment;

import com.example.demo.entity.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private String merchantUid;

    @CreationTimestamp
    private LocalDateTime regDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
    private Reservation reservation;

    public void addReservationToPayment(Reservation reservation){
        this.reservation = reservation;
        reservation.setPayment(this);
    }
}
