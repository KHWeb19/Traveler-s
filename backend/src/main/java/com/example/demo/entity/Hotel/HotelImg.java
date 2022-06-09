package com.example.demo.entity.Hotel;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table( name = "Hotel_File_Img" )
@NoArgsConstructor
public class HotelImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "File_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Hotel_No")
    private Hotel hotelNo;

    @Column(nullable = false)
    private String origFileName;  // 파일 원본명

    @Column(nullable = false)
    private String filePath;  // 파일 저장 경로

    private Long fileSize;

    @Builder
    public HotelImg(String origFileName, String filePath, Long fileSize){
        this.origFileName = origFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}
