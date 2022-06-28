package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.room.RoomRepository;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
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
    private final UserRepository userRepository;

    String path = "roomImg";
    @Override
    public void register(RoomRequest roomRequest, List<MultipartFile> files) throws Exception {

        List<String> filePathList = new ArrayList<>();
        log.info("hotelNo : " + roomRequest.getHotelNo());
        Optional<Hotel> hotelOptional = hotelRepository.findByHotelNo(roomRequest.getHotelNo());

        Hotel hotel = hotelOptional.get();
        log.info("hotel :" + hotel);
        fileUpload(files,path,filePathList);

        Room room = Room.builder()
                .roomType(roomRequest.getRoomType())
                .price(roomRequest.getPrice())
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
    public List<RoomResponse> findHotel(String email) {
        log.info("email : " + email);
        Optional<User> optionalUser = userRepository.findByEmailWithHotels(email);
        User user = optionalUser.get();
        List<Hotel> hotelList = user.getHotels();
        List<RoomResponse> ceoHotel = new ArrayList<>();
        RoomResponse roomResponse;
        for(Hotel hotel : hotelList){
            roomResponse = new RoomResponse(hotel.getHotelNo(),hotel.getHotelName());
            ceoHotel.add(roomResponse);
        }

        return ceoHotel;
    }

    @Override
    public List<Room> findRoomList(Long hotelNo) {

        return  roomRepository.findAllRoomByHotelNo(hotelNo);
    }

    @Override
    public Room bmRoomRead(Integer roomNo) {

        Optional<Room> maybeReadBoard = roomRepository.findById(Long.valueOf(roomNo));
        log.info("ROOMREAD : " + maybeReadBoard);
        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public Room bmRoomModify(Room room, List<MultipartFile> files) {
        Optional<Room> roomInfo = roomRepository.findById(room.getRoomNo());
        Hotel hotel = roomInfo.get().getHotel();
        //어떻게 못하겠다 나의 한계
        if(roomInfo.get().getRoomImgPath1() != null){fileRemove(roomInfo.get().getRoomImgPath1(), path);}
        if(roomInfo.get().getRoomImgPath2() != null){fileRemove(roomInfo.get().getRoomImgPath2(), path);}
        if(roomInfo.get().getRoomImgPath3() != null){fileRemove(roomInfo.get().getRoomImgPath3(), path);}
        if(roomInfo.get().getRoomImgPath4() != null){fileRemove(roomInfo.get().getRoomImgPath4(), path);}
        if(roomInfo.get().getRoomImgPath5() != null){fileRemove(roomInfo.get().getRoomImgPath5(), path);}
        if(roomInfo.get().getRoomImgPath6() != null){fileRemove(roomInfo.get().getRoomImgPath6(), path);}
        if(roomInfo.get().getRoomImgPath7() != null){fileRemove(roomInfo.get().getRoomImgPath7(), path);}
        if(roomInfo.get().getRoomImgPath8() != null){fileRemove(roomInfo.get().getRoomImgPath8(), path);}
        if(roomInfo.get().getRoomImgPath9() != null){fileRemove(roomInfo.get().getRoomImgPath9(), path);}
        //이것도 나의 한계
        room.setHotel(hotel);

        List<String> filePathList = new ArrayList<>();
        fileUpload(files, path, filePathList);
        log.info("filePathList : " + filePathList);
        //이것도 나의 한계
        for (int i = 0; i < filePathList.size(); i++) {
            switch (i) {
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
         return roomRepository.save(room);

    }

    @Override
    public void bmRoomRemove(Integer roomNo) {
        Optional<Room> roomInfo = roomRepository.findById(Long.valueOf(roomNo));

        if(roomInfo.get().getRoomImgPath1() != null){fileRemove(roomInfo.get().getRoomImgPath1(), path);}
        if(roomInfo.get().getRoomImgPath2() != null){fileRemove(roomInfo.get().getRoomImgPath2(), path);}
        if(roomInfo.get().getRoomImgPath3() != null){fileRemove(roomInfo.get().getRoomImgPath3(), path);}
        if(roomInfo.get().getRoomImgPath4() != null){fileRemove(roomInfo.get().getRoomImgPath4(), path);}
        if(roomInfo.get().getRoomImgPath5() != null){fileRemove(roomInfo.get().getRoomImgPath5(), path);}
        if(roomInfo.get().getRoomImgPath6() != null){fileRemove(roomInfo.get().getRoomImgPath6(), path);}
        if(roomInfo.get().getRoomImgPath7() != null){fileRemove(roomInfo.get().getRoomImgPath7(), path);}
        if(roomInfo.get().getRoomImgPath8() != null){fileRemove(roomInfo.get().getRoomImgPath8(), path);}
        if(roomInfo.get().getRoomImgPath9() != null){fileRemove(roomInfo.get().getRoomImgPath9(), path);}


        roomRepository.deleteById(Long.valueOf(roomNo));
    }

    @Override
    public void bmRoomsRemove(List<Long> roomNo) {
        for(int i = 0 ; i < roomNo.size(); i++) {
            Optional<Room> roomInfo = roomRepository.findById(roomNo.get(i));

            if (roomInfo.get().getRoomImgPath1() != null) {
                fileRemove(roomInfo.get().getRoomImgPath1(), path);
            }
            if (roomInfo.get().getRoomImgPath2() != null) {
                fileRemove(roomInfo.get().getRoomImgPath2(), path);
            }
            if (roomInfo.get().getRoomImgPath3() != null) {
                fileRemove(roomInfo.get().getRoomImgPath3(), path);
            }
            if (roomInfo.get().getRoomImgPath4() != null) {
                fileRemove(roomInfo.get().getRoomImgPath4(), path);
            }
            if (roomInfo.get().getRoomImgPath5() != null) {
                fileRemove(roomInfo.get().getRoomImgPath5(), path);
            }
            if (roomInfo.get().getRoomImgPath6() != null) {
                fileRemove(roomInfo.get().getRoomImgPath6(), path);
            }
            if (roomInfo.get().getRoomImgPath7() != null) {
                fileRemove(roomInfo.get().getRoomImgPath7(), path);
            }
            if (roomInfo.get().getRoomImgPath8() != null) {
                fileRemove(roomInfo.get().getRoomImgPath8(), path);
            }
            if (roomInfo.get().getRoomImgPath9() != null) {
                fileRemove(roomInfo.get().getRoomImgPath9(), path);
            }


            roomRepository.deleteById(roomNo.get(i));
        }
    }

}
