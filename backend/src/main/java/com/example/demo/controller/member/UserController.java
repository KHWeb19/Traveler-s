package com.example.demo.controller.member;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.dto.member.AuthResponse;
import com.example.demo.dto.member.LoginRequest;
import com.example.demo.dto.member.MemberRequest;
import com.example.demo.dto.member.MobileRequest;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.Code;
import com.example.demo.entity.member.User;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.member.UserService;
import com.example.demo.utility.customUserDetails.CustomUserDetails;
import com.example.demo.utility.customUserDetails.CustomUserDetailsService;
import com.example.demo.utility.oauth2.CookieUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        log.info("Set authentication");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String access_token = tokenProvider.createAccessToken(authentication);
        String refresh_token = tokenProvider.createRefreshToken(authentication);

        CookieUtils.addCookie(response, "refresh_token", refresh_token, 12096000);

        httpSession.setAttribute("key", refresh_token);

        return ResponseEntity.ok(new AuthResponse(access_token));
    }

    @GetMapping("/listall")
    public List<User> login(){
        log.info("()()()))");
        return userService.listAll();
    }

    @PostMapping("/user/register")
    public String register(@RequestBody MemberRequest userRequest) {
        log.info("userRequest :" + userRequest);
        String duplicationMessage = userService.emailDuplicationCheck(userRequest.getEmail());

        if (duplicationMessage != null) {
            return duplicationMessage;
        }

       /* Role role = new Role(userRequest.getRole());
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .roles(roleList)
                .mobile(userRequest.getMobile())
                .build();*/

        userService.addUser(userRequest);

        //userService.addRoleToUser(user, role);

        return "가입되었습니다";
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

    @PostMapping("/check-number")
    public String checkNumber(@RequestBody MobileRequest mobile){

        String duplicationMessage = userService.mobileDuplicationCheck(mobile);

        if(duplicationMessage != null){
            return duplicationMessage;
        }
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        log.info("numStr : " + numStr);
        String phoneNumber = mobile.getMobile();
        log.info("mobile :" + phoneNumber);
        userService.cellPhoneCheck(phoneNumber, numStr);
        return numStr;
    }
    //엑세스 토큰이 만료되면 이쪽으로 url을 보내서 refresh_token을 확인 한다고 함
    @PostMapping("/refreshtoken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Refreshing tokens...");
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        Optional<Cookie> refresh_cookie = CookieUtils.getCookie(request, "refresh_token");
        String refresh_token = refresh_cookie.get().getValue();

        if (httpSession.getAttribute("key").equals(refresh_token)) {
            if (refresh_token != null) {
                try {

                    Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());

                    DecodedJWT decodedJWT = tokenProvider.decodeJwt(refresh_token);

                    log.info("* DECODING SUCCESSFUL");

                    String email = decodedJWT.getSubject();
                    User user = userService.findByEmail(email).get();

                    String access_token = JWT.create()
                            .withSubject(user.getEmail())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 10))
                            .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                            .sign(algorithm);
                    Map<String, String> tokens = new HashMap<>();
                    tokens.put("access_token", access_token);
                    //tokens.put("refresh_token",  refresh_token);
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                } catch (Exception exception) {
                    log.info("* ERROR WHILE DECODING");
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(UNAUTHORIZED.value());
                    //response.sendError(FORBIDDEN.value());
                    Map<String, String> error = new HashMap<>();
                    error.put("error_message", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }
            } else {
                throw new RuntimeException("Refresh token is missing");
            }
        } else{
            log.info("* Session value does not equal to Cookie");
        }
    }
}