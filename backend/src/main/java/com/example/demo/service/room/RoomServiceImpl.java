package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.room.RoomRepository;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomServiceImpl extends FileUpload implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public void register(RoomRequest roomRequest, List<MultipartFile> files) throws Exception {
        String path = "roomImg";
        List<String> filePathList = new ArrayList<>();
        log.info("hotelNo : " + roomRequest.getHotelNo());
        Optional<Hotel> hotelOptional = hotelRepository.findByHotelNo(roomRequest.getHotelNo());

        Hotel hotel = hotelOptional.get();
        log.info("hotel :" + hotel);
        fileUpload(files,path,filePathList);

        Room room = Room.builder()
                .roomName(roomRequest.getRoomName())
                .roomType(roomRequest.getRoomType())
                .roomInfo(roomRequest.getRoomInfo())
                .personnel(roomRequest.getPersonnel())
                .hotel(hotel)
                .build();


        for(int i = 0; i < filePathList.size(); i++) {
            switch (i){
                case 0:
                    room.setRoomImgPath1(filePathList.get(i));
                    break;
                case 1:
                    room.setRoomImgPath2(filePathList.get(i));
                    break;
                case 2:
                    room.setRoomImgPath3(filePathList.get(i));
                    break;
                case 3:
                    room.setRoomImgPath4(filePathList.get(i));
                    break;
                case 4:
                    room.setRoomImgPath5(filePathList.get(i));
                    break;
                case 5:
                    room.setRoomImgPath6(filePathList.get(i));
                    break;
                case 6:
                    room.setRoomImgPath7(filePathList.get(i));
                    break;
                case 7:
                    room.setRoomImgPath8(filePathList.get(i));
                    break;
                case 8:
                    room.setRoomImgPath9(filePathList.get(i));
                    break;
            }

        }
        log.info("room : " + room);

        roomRepository.save(room);
    }

    @Override
    public List<RoomResponse> findHotel(String writer) {
        log.info("writer : " + writer);
        List<Hotel> hotelList = hotelRepository.findByWriter(writer);
        List<RoomResponse> ceoHotel = new ArrayList<>();
        RoomResponse roomResponse;
        for(Hotel hotel : hotelList){
            roomResponse = new RoomResponse(hotel.getHotelNo(),hotel.getHotelName());
            ceoHotel.add(roomResponse);
        }

        return ceoHotel;
    }
}
