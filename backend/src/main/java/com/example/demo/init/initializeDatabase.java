package com.example.demo.init;

import com.example.demo.entity.hotel.Hotel;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.hotel.HotelRepository;
import com.example.demo.repository.member.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class initializeDatabase implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    private String FILE_PATH = "../frontend/src/hotelImg/";

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role("ADMIN");
        User user = User.builder().email("admin@gmail.com")
                .password(passwordEncoder.encode("password"))
                .profile_path("default.png")
                .build();
        user.addRoleToUser(role);
        userRepository.save(user);

        Hotel hotel = new Hotel("hotelName","hotelIntro", "totalAddress", "postcode",
                FILE_PATH + "hotel1.jpg", FILE_PATH + "hotel2.jpg", FILE_PATH + "hotel3.jpg",
                FILE_PATH + "hotel4.jpg", FILE_PATH + "hotel5.jpg");
        hotelRepository.save(hotel);
        System.out.println("CommandLine Runner");
    }
}
