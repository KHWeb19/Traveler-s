package com.example.demo.init;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
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

    private String FILE_PATH = "../frontend/src/hotelImg/";

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("ADMIN");
        User user = User.builder().email("admin@gmail.com")
                .password(passwordEncoder.encode("password"))
                .name("admin")
                .profile_path("default.png")
                .build();
        user.addRoleToUser(role);
        userRepository.save(user);
        List<Hotel> hotels = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Hotel hotel = new Hotel(String.format("Hotel#%d", i),"hotelIntro", "오션뷰,테라스,수영장,전기차충전,공항근처,골프장,무료주차,바베큐그릴,반려동물,온천",
                    "전남 진도군 조도면 대마도길 8대마도호텔", "58958",
                    String.format("hotel%d-1.jpg", i), String.format("hotel%d-2.jpg", i), String.format("hotel%d-3.jpg", i),
                    String.format("hotel%d-4.jpg", i), String.format("hotel%d-5.jpg", i));
            hotels.add(hotel);
        }
        hotelRepository.saveAll(hotels);
        System.out.println("CommandLine Runner");
    }
}
