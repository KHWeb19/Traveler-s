package com.example.demo.controller.member;

import com.example.demo.dto.member.AuthResponse;
import com.example.demo.dto.member.LoginRequest;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.Code;
import com.example.demo.entity.member.User;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.member.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        log.info("Set authentication");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }
    
    @GetMapping
    public String index(Authentication authentication){
        //OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        //System.out.println("**********" +oAuth2User.getAttributes());

        return "세션 확인";

    }

    @GetMapping("/listall")
    public List<User> login(){
        return userService.listAll();
    }

    @PostMapping("/user/register")
    public void register(){
        User user = new User("admin", "admin@gmail.com", "password");
        Role role = new Role("ADMIN");
        userService.addUser(user);

        userService.addRoleToUser(user, role);
    }

    @GetMapping("/kakaoLogin")
    public String kakaoLogin(String code){

        RestTemplate restTemplate = new RestTemplate();

        Code authorizeCode  = new Code(code);

        String result = restTemplate.postForObject(
                "http://localhost:5000/kakao-login",
                authorizeCode,
                String.class
        );

        log.info("result = " + result);

        return result;
    }

}
