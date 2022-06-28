package com.example.demo.service.hotel;


import com.example.demo.controller.hotel.response.HotelResponse;
import com.example.demo.dto.hotel.HotelResponseWithWriter;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HotelServiceImpl extends FileUpload implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    // 사업자 매뉴얼 호텔 등록
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

    @Override
    public List<Hotel> bmHotelList() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmailWithHotels(email).get();
        return user.getHotels();

    }

    // 사업자 매뉴얼 호텔 읽기
    @Override
    public Hotel bmHotelRead(Integer hotelNo) {
        log.info("hotelNo" + hotelNo);
        Optional<Hotel> maybeReadBoard = hotelRepository.findById(Long.valueOf(hotelNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    // 사업자 매뉴얼 호텔 수정
    @Override
    public void bmhotelModify(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    // 사업자 매뉴얼 호텔 삭제
    @Override
    public void bmhotelRemove(Integer hotelNo) {
        hotelRepository.deleteById(Long.valueOf(hotelNo));
    }


    // ---------------------------------------------------------------------------------------------------------------



    public List<Hotel> random () {
        log.info("HotelServiceIMPL random");
        List<Hotel> randomResults = hotelRepository.randomPick(6);

        return randomResults;
    }

    public HotelResponseWithWriter mRead(Integer hotelNo) {
        Optional<Hotel> maybeReadBoard = hotelRepository.findByIdWithUser(Long.valueOf(hotelNo));
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

        Hotel hotel = maybeReadBoard.get();
        HotelResponseWithWriter hotelResponseWithWriter = HotelResponseWithWriter.builder().
                hotelInfo(hotel.getHotelInfo())
                .hotelImgPath1(hotel.getHotelImgPath1())
                .hotelImgPath2(hotel.getHotelImgPath2())
                .hotelImgPath3(hotel.getHotelImgPath3())
                .hotelImgPath4(hotel.getHotelImgPath4())
                .hotelImgPath5(hotel.getHotelImgPath5())
                .hotelImgPath6(hotel.getHotelImgPath6())
                .hotelIntro(hotel.getHotelIntro())
                .hotelNo(hotel.getHotelNo())
                .hotelName(hotel.getHotelName())
                .openKakaotalk(hotel.getOpenKakaotalk())
                .postcode(hotel.getPostcode())
                .regDate(hotel.getRegDate())
                .updDate(hotel.getUpdDate())
                .totalAddress(hotel.getTotalAddress())
                .writer(hotel.getUser().getEmail())
                .build();

        return hotelResponseWithWriter;
    }

}