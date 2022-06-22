package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.utility.customUserDetails.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    public String createAccessToken(Authentication authentication) {
        log.info("Creating access_token...");
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());


        return JWT.create()
                .withSubject(customUserDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                //.withClaim("roles", authResult.getAuthorities().stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r)).collect(Collectors.toList()))
                .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }

    public String createRefreshToken(Authentication authentication) {
        log.info("Creating refresh_token...");

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());
        System.out.println("****" + customUserDetails.getUsername());

        return JWT.create()
                .withSubject(customUserDetails.getUsername()) //토큰 제목 - 토큰에서 사용자에 대한 식별 값이 됨
                //.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 15)) //15초 테스트용
                .withExpiresAt(new Date(System.currentTimeMillis()+ 12096000)) // 2주
                //.withIssuer(authentication.getPrincipal().toString()) //토근 발급자
                .sign(algorithm);
    }

    public DecodedJWT decodeJwt(String token){

        Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
/*

        Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        */
        return decodedJWT;

    }

}