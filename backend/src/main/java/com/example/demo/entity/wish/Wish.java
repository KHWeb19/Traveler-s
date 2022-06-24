package com.example.demo.entity.wish;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Wish")
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch =FetchType.LAZY)
    private Hotel hotel;


}
