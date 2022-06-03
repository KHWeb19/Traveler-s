package com.example.demo.entity.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Lob
    private String content;

    @Lob
    private  String rating;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    // 외래키
    private Long userNo;

    // 외래키
    private Long roomNo;



}