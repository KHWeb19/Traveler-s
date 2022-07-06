package com.example.demo.security;

import com.example.demo.service.member.CustomOAuth2UserService;
import com.example.demo.utility.customUserDetails.CustomUserDetailsService;
import com.example.demo.utility.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.example.demo.utility.oauth2.OAuth2AuthenticationFailureHandler;
import com.example.demo.utility.oauth2.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.GET;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    //@Bean은 해당 메서드의 리턴되는 오브젝트를 IoC로 등록 해준다
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //csrf(Cross-site Request Forgery) - 사이트간 요청 위조, 웹 애플리케이션의 취약점중 하나로, 이용자가 의도하지않은 공격
        //이용자가 자신의 의지와는 무관하게 공격자가 의도한 행위(등록,수정,삭제등)를 특정 웹사이트에 요청하도록 하는 공격
        http

                .authorizeRequests((authz ->
                        authz.antMatchers("/h2-console/**", "/login", "/user/register", "/oauth2/authorize/**",
                                        "/oauth2/callback/**","/","/kakaoLogin","/check-number", "/refreshtoken",
                                        "/hotel/**","/hotel/**/**","/room/**","/room/**/**","/search/**","/getUser", "wish/**/**").permitAll()
                                .antMatchers("/hotel/hotelRegister", "/hotel/bm/**", "/reserve/ceo/**").hasRole("CEO")
                                //.antMatchers(GET, "/listall").hasAnyAuthority("ROLE_USER")
                                .anyRequest().authenticated())

                )
                .csrf((c) -> c.disable())
                .cors().and()
                .headers((h -> h.frameOptions().disable()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(eh -> eh.authenticationEntryPoint(new RestAuthenticationEntryPoint()))
                .oauth2Login(auth -> auth
                        .authorizationEndpoint( ae ->
                                ae.baseUri("/oauth2/authorize")
                                        .authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository))
                        .redirectionEndpoint(re ->
                                re.baseUri("/login/oauth2/code/*"))
                        .userInfoEndpoint(ue ->
                                ue.userService(customOAuth2UserService))
                        .successHandler(oAuth2AuthenticationSuccessHandler)
                        .failureHandler(oAuth2AuthenticationFailureHandler))
                .addFilterBefore(jwtVerificationFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .deleteCookies("refresh_token")
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)));


        return http.build();
    }

    //비밀번호 암호화 안하면 security로 로그인 할 수 없음


    @Bean
    public JWTVerificationFilter jwtVerificationFilter(){
        return new JWTVerificationFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

/*
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }
*/

}

