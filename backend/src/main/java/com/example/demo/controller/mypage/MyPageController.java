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

import java.util.Optional;

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

        MyPageResponse myPageResponse = new MyPageResponse(user.getName(), user.getEmail());

        return new ResponseEntity<MyPageResponse>(myPageResponse, HttpStatus.OK);
    }
    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam("password") String password){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userService.findByEmail(email);
        User user = optionalUser.get();

        user.setPassword(passwordEncoder.encode(password));
        userService.saveUser(user);

        return ResponseEntity.ok().build();
    }
}
