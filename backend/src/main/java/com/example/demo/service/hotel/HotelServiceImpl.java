package com.example.demo.service.hotel;

import com.example.demo.dto.hotel.HotelRequest;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.hotel.HotelImage;
import com.example.demo.entity.member.User;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.utility.FileUtility;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.dto.hotel.HotelResponse.hotelBuilder;

@Slf4j
@Service
public class HotelServiceImpl extends FileUpload implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;
    String path = "hotelImg";

    // 사업자 매뉴얼 호텔 등록
    @Override
    public void register(HotelRequest hotelRequest, List<MultipartFile> files, User user) throws Exception {


        List<String> filePathList = new ArrayList<>();

        Hotel hotel = Hotel.builder()
                        .hotelName(hotelRequest.getHotelName())
                        .hotelInfo(hotelRequest.getHotelInfo())
                        .hotelIntro(hotelRequest.getHotelIntro())
                        .postcode(hotelRequest.getPostcode())
                        .totalAddress(hotelRequest.getTotalAddress())
                        .user(user)
                        .build();

        fileUpload(files,path,filePathList);

        addHotelImgPath(hotel,filePathList);

        hotelRepository.save(hotel);
    }

    @Override
    public List<HotelResponse> bmHotelList() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmailWithHotels(email).get();
        log.info("hotels : " + user.getHotels() );

        return hotelBuilder(user.getHotels());

    }

    // 사업자 매뉴얼 호텔 읽기
    @Override
    public HotelResponse bmHotelRead(Integer hotelNo) {
        log.info("hotelNo" + hotelNo);
        Optional<Hotel> maybeReadBoard = hotelRepository.findByIdWithUser(Long.valueOf(hotelNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return hotelBuilder(maybeReadBoard.get());
    }

    // 사업자 매뉴얼 호텔 수정
    @Override
    public HotelResponse bmHotelModify(HotelRequest hotelRequest, List<MultipartFile> files, Integer hotelNo, List<String> oldFiles) {
        Optional<Hotel> hotelInfo = hotelRepository.findByIdWithUser(Long.valueOf(hotelNo));
        Hotel hotel = hotelInfo.get();

        hotel.setHotelInfo(hotelRequest.getHotelInfo());
        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setHotelIntro(hotelRequest.getHotelIntro());

        List<HotelImage> hotelImages = hotel.getHotelImages();

        List<HotelImage> imagesToRemove = new ArrayList<>();
        hotelImages.forEach(f -> {
            if (!oldFiles.contains(f.getPath())){
                imagesToRemove.add(f);
                FileUtility.deleteImage(f.getPath(), "hotelImg");
            } else{
                log.info("file: {} stil exists", f.getPath().toString());
            }
        });
        imagesToRemove.forEach(f -> hotel.removeHotelImageFromHotel(f));

        List<String> filePathList = new ArrayList<>();
        fileUpload(files, path, filePathList);
        log.info("filePathList : " + filePathList);

        addHotelImgPath(hotel, filePathList);
        hotelRepository.save(hotel);
        return hotelBuilder(hotel);
    }

    // 사업자 매뉴얼 호텔 삭제
    @Override
    public void bmHotelRemove(Integer hotelNo) {

        Optional<Hotel> hotelInfo = hotelRepository.findById(Long.valueOf(hotelNo));

        hotelImgPathRemove(hotelInfo.get(), path);

        hotelRepository.deleteById(Long.valueOf(hotelNo));
    }

    @Override
    public void bmHotelsRemove(List<Long> hotelNo) {
        for(int i = 0 ; i < hotelNo.size(); i++) {
            Optional<Hotel> hotelInfo = hotelRepository.findById(hotelNo.get(i));

            //수정필요한부분
            //hotelImgPathRemove(hotelInfo, path);

            hotelRepository.deleteById(hotelNo.get(i));
        }
    }


    // ---------------------------------------------------------------------------------------------------------------


    @Transactional
    public List<HotelResponse> random () {
        log.info("HotelServiceIMPL random");
        List<Hotel> randomResults = hotelRepository.randomPick(6);

        //List<HotelResponse> responses = new ArrayList<>();


        /*for(Hotel hotel : randomResults) {
            responses.add(new HotelResponse(
                    hotel.getHotelNo(), hotel.getHotelImages().get(0).getPath(), hotel.getHotelName(), hotel.getTotalAddress(), hotel.getHotelInfo()
            ));
        }*/
        return hotelBuilder(randomResults);
    }

    public HotelResponse mRead(Integer hotelNo) {
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

        return hotelBuilder(hotel);
    }
}