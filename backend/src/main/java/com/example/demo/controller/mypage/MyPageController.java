package com.example.demo.controller.mypage;

import com.example.demo.dto.member.MyPageResponse;
import com.example.demo.entity.member.User;
import com.example.demo.service.member.UserService;
import com.example.demo.utility.FileUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static com.example.demo.utility.FileUtility.FILE_PATH;
import static com.example.demo.utility.FileUtility.createFileAndReturnPath;

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

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();
        String currentProfilePath = user.getProfile_path();

        String newFilePath = createFileAndReturnPath(multipartFile, currentProfilePath);
        user.setProfile_path(newFilePath);
        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }

}