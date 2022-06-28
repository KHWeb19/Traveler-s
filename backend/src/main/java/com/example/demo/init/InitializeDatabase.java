package com.example.demo.init;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.entity.room.Room;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.repository.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializeDatabase implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    private String FILE_PATH = "../frontend/src/hotelImg/";

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role("ADMIN");
        Role roleCEO = new Role("CEO");
        Role roleUser = new Role("USER");
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
            Hotel hotel = new Hotel(String.format("Hotel#%d", i),"hotelIntro", "오션뷰,테라스,수영장,전기차충전,공항근처,골프장,무료주차,바베큐그릴,반려동물,온천",
                    "전남 진도군 조도면 대마도길 8대마도호텔", "58958",
                    String.format("hotel%d-1.jpg", i), String.format("hotel%d-2.jpg", i), String.format("hotel%d-3.jpg", i),
                    String.format("hotel%d-4.jpg", i), String.format("hotel%d-5.jpg", i));
            hotel.addUserToHotel(userCEO);
            hotels.add(hotel);
            for (int j = 1; j <=5 ; j++) {
                Room room = Room.builder()
                        .price(99999L)
                        .personnel(4)
                        .roomInfo(roomInfo)
                        .roomType("roomType")
                        .roomImgPath1(String.format("room%d-1.jpg", j))
                        .roomImgPath2(String.format("room%d-2.jpg", j))
                        .roomImgPath3(String.format("room%d-3.jpg", j))
                        .roomImgPath4(String.format("room%d-4.jpg", j))
                        .roomImgPath5(String.format("room%d-5.jpg", j))
                        .build();
                room.addHotelToRoom(hotel);
                rooms.add(room);
            }
        }
        hotelRepository.saveAll(hotels);
        roomRepository.saveAll(rooms);
        System.out.println("CommandLine Runner");
    }
}