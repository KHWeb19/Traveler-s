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
                .mobile("010-1234-1234")
                .build();
        User userCEO = User.builder().email("ceo@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("ceo")
                .profile_path("default.png")
                .mobile("010-1234-1234")
                .build();
        User userUser = User.builder().email("user@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("user")
                .profile_path("default.png")
                .mobile("010-1234-1234")
                .build();
        User userTest = User.builder().email("test@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("test")
                .profile_path("default.png")
                .mobile("010-1234-1234")
                .build();
        userAdmin.addRoleToUser(roleAdmin);
        userCEO.addRoleToUser(roleCEO);
        userUser.addRoleToUser(roleUser);
        userTest.addRoleToUser(roleUser);
        userRepository.saveAll(List.of(userAdmin, userCEO, userUser, userTest));
        List<String> roomInfo = List.of("??????,??????,????????????,?????????,?????????,?????????,?????????,TV,????????????,?????????");

        List<Hotel> hotels = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {

            Hotel hotel = Hotel.builder()
                    .hotelName(String.format("Hotel%d", i))
                    .hotelIntro("hotelIntro")
                    .hotelInfo(List.of("?????????,?????????,?????????,???????????????,????????????,?????????,????????????,???????????????,????????????,??????"))
                    .totalAddress("?????? ????????? ????????? ???????????? 8???????????????")
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
                        .price(1000L)
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
        //Room id 1?????? ?????? ??????????????? 3??? ??????
        Room room = rooms.get(0);
        Reservation reservation = Reservation.builder()
                .startDate(LocalDate.parse("2022-07-01"))
                .endDate(LocalDate.parse("2022-07-07"))
                .status(ReservationStatus.PENDING)
                .price(1000L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservation);
        Reservation reservationTwo = Reservation.builder()
                .startDate(LocalDate.parse("2022-08-01"))
                .endDate(LocalDate.parse("2022-08-07"))
                .status(ReservationStatus.RESERVED)
                .price(1000L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservationTwo);
        Reservation reservationThree = Reservation.builder()
                .startDate(LocalDate.parse("2022-09-01"))
                .endDate(LocalDate.parse("2022-09-07"))
                .status(ReservationStatus.CANCELLED)
                .price(1000L)
                .room(room)
                .user(userUser)
                .build();
        room.addReservationToRoom(reservationThree);
        roomRepository.save(room);
        System.out.println("CommandLine Runner");
    }
}




