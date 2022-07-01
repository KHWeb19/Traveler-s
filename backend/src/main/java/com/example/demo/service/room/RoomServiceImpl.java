package com.example.demo.service.room;

import com.example.demo.dto.hotel.RoomRequest;
import com.example.demo.dto.hotel.HotelResponse;
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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.dto.hotel.RoomResponse.roomBuilder;
import static com.example.demo.dto.reservation.ReservationBuilder.reservationBuilder;

//import static com.example.demo.dto.hotel.RoomResponse.roomBuilder;

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
        room.addReservationToRoom(reservationBuilder(room, hotel.getUser()));
        log.info("room : " + room);

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
   public List<RoomResponse> findMRoomList(Long hotelNo) {

       Optional<Hotel> optionalHotel = hotelRepository.findByIdWithRooms(hotelNo);
       Hotel hotel = optionalHotel.get();
       List<Room> rooms = hotel.getRooms();

       return roomBuilder(rooms);
   }
}
