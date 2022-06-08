package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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

    public String createToken(Authentication authentication) {
        log.info("Creating token...");
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());


        //토큰에 개인정보 지금 들어가는가?
        return JWT.create()
                .withSubject(authentication.getPrincipal().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                //.withClaim("roles", authResult.getAuthorities().stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r)).collect(Collectors.toList()))
                .withClaim("roles", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
}
