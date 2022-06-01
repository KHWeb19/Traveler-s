package com.example.demo.security;

import com.example.demo.service.member.CustomOAuth2UserService;
import com.example.demo.utility.customUserDetails.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomOAuth2UserService customOAuth2UserService;

    //@Bean은 해당 메서드의 리턴되는 오브젝트를 IoC로 등록 해준다
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //csrf(Cross-site Request Forgery) - 사이트간 요청 위조, 웹 애플리케이션의 취약점중 하나로, 이용자가 의도하지않은 공격
        //이용자가 자신의 의지와는 무관하게 공격자가 의도한 행위(등록,수정,삭제등)를 특정 웹사이트에 요청하도록 하는 공격
        http.csrf().disable();
        http
                .authorizeRequests()
                        .antMatchers("/login", "/register", "/kakaoLogin").permitAll()
                //.antMatchers("/").access("hasRole('ROLE_USER')")
                        .anyRequest().authenticated()

                .and()
                //.formLogin()
                //.and()
                //.authenticationProvider(daoAuthenticationProvider())
                .oauth2Login()
                //.loginPage("/login") //인증 필요한 페이지 접근시 로그인 안했으면 /login 페이지로 이동
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        return http.build();
    }
    //비밀번호 암호화 안하면 security로 로그인 할 수 없음
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
        config.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}




