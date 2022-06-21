package com.example.demo.service.hotel;


import com.example.demo.entity.hotel.Hotel;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class HotelServiceImpl extends FileUpload implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public void register(Hotel hotel, List<MultipartFile> files) throws Exception {

        String path = "hotelImg";
        List<String> filePathList = new ArrayList<>();

        fileUpload(files,path,filePathList);

        for(int i = 0; i < filePathList.size(); i++) {
            switch (i){
                case 0:
                     hotel.setHotelImgPath1(filePathList.get(i));
                break;
                case 1:
                    hotel.setHotelImgPath2(filePathList.get(i));
                    break;
                case 2:
                    hotel.setHotelImgPath3(filePathList.get(i));
                    break;
                case 3:
                    hotel.setHotelImgPath4(filePathList.get(i));
                    break;
                case 4:
                    hotel.setHotelImgPath5(filePathList.get(i));
                    break;
                case 5:
                    hotel.setHotelImgPath6(filePathList.get(i));
                    break;
                case 6:
                    hotel.setHotelImgPath7(filePathList.get(i));
                    break;
                case 7:
                    hotel.setHotelImgPath8(filePathList.get(i));
                    break;
                case 8:
                    hotel.setHotelImgPath9(filePathList.get(i));
                    break;
            }

        }


        hotelRepository.save(hotel);
    }

    /*
    @Override
    public List<Hotel> list() {
        log.info("HotelServiceIMPL list");
        return hotelRepository.findAll(Sort.by(Sort.Direction.DESC, "hotelNo"));
    }*/


    public List<Hotel> random () {
        log.info("HotelServiceIMPL random");
        List<Hotel> randomResults = hotelRepository.randomPick(6);

        return randomResults;
    }



    @Override
    public Hotel mRead(Integer hotelNo) {
        Optional<Hotel> maybeReadBoard = hotelRepository.findById(Long.valueOf(hotelNo));
        //Optional: null일 수도 있는 객체를 감싸는 일종의 Wrapper 클래스
        /*
        optional 변수 내부에는 null이 아닌 T 객체가 있을 수도 있고 null이 있을 수도 있습니다.
        따라서, Optional 클래스는 여러 가지 API를 제공하여 null일 수도 있는 객체를 다룰 수 있도록 돕습니다
         */
        log.info("HotelServiceIMPL readOK");
        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();

    }

    @Override
    public void modify(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void remove(Integer hotelNo) {
        hotelRepository.deleteById(Long.valueOf(hotelNo));
    }
}