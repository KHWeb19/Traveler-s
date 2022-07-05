package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.HotelResponse;
import com.example.demo.dto.hotel.RoomResponse;
import com.example.demo.dto.search.KeyWordRequest;
import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.ReservationStatus;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.room.RoomRepository;
import com.example.demo.utility.fileUpload.FileUpload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.dto.hotel.RoomResponse.roomBuilder;


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
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomRequest.getHotelNo());

        Hotel hotel = hotelOptional.get();
        log.info("hotel :" + hotel);
        fileUpload(files,path,filePathList);

        Room room = Room.builder()
                .roomType(roomRequest.getRoomType())
                .price(roomRequest.getPrice())
                .personnel(roomRequest.getPersonnel())
                .roomInfo(roomRequest.getRoomInfo())
                .hotel(hotel)
                .build();


        addRoomImgPath(room,filePathList);

        roomRepository.save(room);
    }

    @Override
    public List<HotelResponse> findHotel(String email) {
        log.info("email : " + email);
        Optional<User> optionalUser = userRepository.findByEmailWithHotels(email);
        User user = optionalUser.get();

        List<Hotel> hotelList = user.getHotels();

        List<HotelResponse> ceoHotel = new ArrayList<>();
        HotelResponse roomResponse;

        for(Hotel hotel : hotelList){
            roomResponse = new HotelResponse(hotel.getHotelNo(),hotel.getHotelName());
            ceoHotel.add(roomResponse);
        }
        return ceoHotel;
    }

    @Override
    public List<RoomResponse> findRoomList(Long hotelNo) {
        Optional<Hotel> hotel = hotelRepository.findByIdWithRooms(hotelNo);
        if(!hotel.equals(Optional.empty())) {
            List<Room> rooms = hotel.get().getRooms();

            return roomBuilder(rooms);
        }
        return new ArrayList<RoomResponse>();
    }

    @Override
    public RoomResponse bmRoomRead(Integer roomNo) {

        Optional<Room> maybeReadBoard = roomRepository.findById(Long.valueOf(roomNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }
        Room room = maybeReadBoard.get();

        return roomBuilder(room);
    }

    @Override
    public Long bmRoomModify(RoomRequest roomRequest, List<MultipartFile> files, Integer roomNo) {
        Optional<Room> roomInfo = roomRepository.findByWithHotel(Long.valueOf(roomNo));
        //어떻게 못하겠다 나의 한계
        Room room = roomInfo.get();
        roomImgPathRemove(room, path);
        //이것도 나의 한계
        Room r = Room.builder()
                .roomNo(Long.valueOf(roomNo))
                .roomType(roomRequest.getRoomType())
                .price(roomRequest.getPrice())
                .roomInfo(roomRequest.getRoomInfo())
                .personnel(roomRequest.getPersonnel())
                .hotel(roomInfo.get().getHotel())
                .build();

        List<String> filePathList = new ArrayList<>();
        fileUpload(files, path, filePathList);
        log.info("filePathList : " + filePathList);
        //이것도 나의 한계
        addRoomImgPath(room,filePathList);

        roomRepository.save(room);
         return r.getRoomNo();

    }

    @Override
    public void bmRoomRemove(Integer roomNo) {
        Optional<Room> roomInfo = roomRepository.findById(Long.valueOf(roomNo));
        Room room = roomInfo.get();
        roomImgPathRemove(room, path);

        roomRepository.deleteById(Long.valueOf(roomNo));
    }

    @Override
    public void bmRoomsRemove(List<Long> roomNo) {
        for(int i = 0 ; i < roomNo.size(); i++) {
            Optional<Room> roomInfo = roomRepository.findById(roomNo.get(i));
            Room room = roomInfo.get();
            roomImgPathRemove(room, path);

            roomRepository.deleteById(roomNo.get(i));
        }
    }

   //--------------------------------------------------------

   @Override
   public List<RoomResponse> findMRoomList(KeyWordRequest keyWordRequest) {
       Optional<Hotel> optionalHotel = hotelRepository.findByIdWithRooms(keyWordRequest.getHotelNo());
       Hotel hotel = optionalHotel.get();
       List<Room> rooms = hotel.getRooms();

       LocalDate date = LocalDate.parse(keyWordRequest.getDates().get(0));
        //그 호텔의 그 인원수 그날짜에 이용중인 룸 구하기
       List<Room> checkDateRooms =
               roomRepository.findByIdAndDateAndPersonnel(keyWordRequest.getHotelNo(),keyWordRequest.getPersonnel(),date, ReservationStatus.CANCELLED);
        log.info("rooms" + checkDateRooms);
        List<Room> deleteRooms = new ArrayList<>();
       if(!checkDateRooms.isEmpty()) {
           log.info("this");
           //룸 리스트에 제외되는 룸 같으면 제외 시키기 ...
           for (Room room : rooms) {
               for (Room checkDateRoom : checkDateRooms) {
                   if (room.getRoomNo() == checkDateRoom.getRoomNo()) {
                       deleteRooms.add(room); // 바로 제거시키면 rooms 변해서 오류생김 그래서 delete에 넣고 제거 ...
                   }
               }
           }
           //포문이 몇개고 하 인생...
           for(Room room : deleteRooms){
           rooms.remove(room);
           }
           //예약 들어 있는 room제거 후에 hotelReponse builder
           return roomBuilder(rooms);
       }
       return roomBuilder(rooms);
   }
}
