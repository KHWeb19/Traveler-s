package com.example.demo.entity.review;

import com.example.demo.entity.Hotel.Hotel;
import com.example.demo.entity.member.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private Date updDate;

    // 외래키
    /**
    @ManyToOne
    private User user;

    */
    // 외래키
    /**
    @ManyToOne
    @JoinColumn(name = "hotelNo")
    private Hotel hotel;
*/



}
