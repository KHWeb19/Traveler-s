package com.example.demo.controller.mypage;

import com.example.demo.dto.member.MyPageResponse;
import com.example.demo.entity.member.User;
import com.example.demo.service.member.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class MyPageController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/getUser")
    public ResponseEntity<MyPageResponse> getUser(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();
        log.info("User: {}", user.toString());

        MyPageResponse myPageResponse = new MyPageResponse(user.getName(), user.getEmail(), user.getProfile_path());

        return new ResponseEntity<MyPageResponse>(myPageResponse, HttpStatus.OK);
    }
    @PostMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam("password") String password){
        log.info("/updatePassword");
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();

        user.setPassword(passwordEncoder.encode(password));
        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/changeProfileImage")
    public ResponseEntity<?> changeProfileImage(@RequestBody MultipartFile multipartFile){
        log.info("* changeProfileImage Controller");
        log.info("MultipartFile: {}", multipartFile.getOriginalFilename());


        UUID uuid = UUID.randomUUID();
        String filePath = "../frontend/src/assets/img/";
        String fileName = uuid + multipartFile.getOriginalFilename();

        try {
            FileOutputStream fos = new FileOutputStream(filePath + fileName);
            fos.write(multipartFile.getBytes());
            log.info("* Saved an image");
            fos.close();
        }
        catch (IOException ioe){
            System.out.println("* Unable to write file: " + ioe.getMessage());
        }

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();
        user.setProfile_path(fileName);
        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }

}
