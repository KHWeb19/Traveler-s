package com.example.demo.security;

import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
public class JWTVerificationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        log.info("OncePerRequestFilter....");

        if (Strings.isBlank(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
            log.info("OncePerRequestFilter token creation skipped...");
            filterChain.doFilter(request, response);
            return;
        }
        try {
            //토큰에 role 확인
            // barer 토큰만 저장
            String token = authorizationHeader.replace("Bearer ", "");

            Algorithm algorithm = Algorithm.HMAC256("SOMESECRET".getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            String username = decodedJWT.getSubject();
            String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            System.out.println("*****" + authorities);
            Arrays.stream(roles).forEach(role -> { authorities.add(new SimpleGrantedAuthority(role));});

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);

        } catch(JwtException e){
            throw new IllegalStateException("Token cannot be verified");
        }

    }
}
