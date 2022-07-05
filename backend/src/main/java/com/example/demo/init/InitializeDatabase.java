package com.example.demo.init;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.hotel.HotelImage;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.entity.reservation.Reservation;
import com.example.demo.entity.reservation.ReservationStatus;
import com.example.demo.entity.room.Room;
import com.example.demo.entity.room.RoomImage;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.reservation.ReservationRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializeDatabase implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    private String FILE_PATH = "../frontend/src/hotelImg/";

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleCEO = new Role("ROLE_CEO");
        Role roleUser = new Role("ROLE_USER");
        User userAdmin = User.builder().email("admin@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("admin")
                .profile_path("default.png")
                .build();
        User userCEO = User.builder().email("ceo@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("ceo")
                .profile_path("default.png")
                .build();
        User userUser = User.builder().email("user@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("user")
                .profile_path("default.png")
                .build();
        userAdmin.addRoleToUser(roleAdmin);
        userCEO.addRoleToUser(roleCEO);
        userUser.addRoleToUser(roleUser);
        userRepository.saveAll(List.of(userAdmin, userCEO, userUser));
        List<String> roomInfo = List.of("오션뷰,테라스,수영장,전기차충전,공항근처,골프장,무료주차,바베큐그릴,반려동물,온천");

        List<Hotel> hotels = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {

            Hotel hotel = Hotel.builder()
                    .hotelName(String.format("Hotel%d", i))
                    .hotelIntro("hotelIntro")
                    .hotelInfo(List.of("오션뷰,테라스,수영장,전기차충전,공항근처,골프장,무료주차,바베큐그릴,반려동물,온천"))
                    .totalAddress("전남 진도군 조도면 대마도길 8대마도호텔")
                    .postcode("58958")
                    .build();

            for (int j = 1; j <= 5; j++) {
                HotelImage hotelImage = HotelImage.builder().path(String.format("hotel%d-%d.jpg", i, j))
                        .hotel(hotel)
                        .build();
                hotel.addHotelImageToHotel(hotelImage);
            }

            for (int k = 1; k <= 3; k++){
                Room room = Room.builder()
                        .price(99999L)
                        .personnel(4)
                        .roomInfo(roomInfo)
                        .roomType("roomType")
                        .hotel(hotel)
                        .build();
                hotel.addRoomToHotel(room);
                for (int l= 1; l <= 2; l++){
                    RoomImage roomImage = RoomImage.builder().path(String.format("hotel%d-room%d-%d.jpg", i, k, l))
                            .room(room)
                            .build();
                    room.addRoomImageToRoom(roomImage);
                }
                hotel.addRoomToHotel(room);
                rooms.add(room);
            }
            hotel.addUserToHotel(userCEO);
            hotels.add(hotel);
        }
        hotelRepository.saveAll(hotels);
        roomRepository.saveAll(rooms);
        //Room id 1번에 대한 예약테이블 3개 생성
        Room room = rooms.get(0);
        Reservation reservation = Reservation.builder()
                .startDate(LocalDate.parse("2022-07-01"))
                .endDate(LocalDate.parse("2022-07-07"))
                .status(ReservationStatus.PENDING)
                .price(9999L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservation);
        Reservation reservationTwo = Reservation.builder()
                .startDate(LocalDate.parse("2022-08-01"))
                .endDate(LocalDate.parse("2022-08-07"))
                .status(ReservationStatus.RESERVED)
                .price(9999L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservationTwo);
        Reservation reservationThree = Reservation.builder()
                .startDate(LocalDate.parse("2022-09-01"))
                .endDate(LocalDate.parse("2022-09-07"))
                .status(ReservationStatus.CANCELLED)
                .price(9999L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservationThree);
        roomRepository.save(room);
        System.out.println("CommandLine Runner");
    }
}




