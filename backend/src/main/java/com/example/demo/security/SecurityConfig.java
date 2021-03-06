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

    //@Bean??? ?????? ???????????? ???????????? ??????????????? IoC??? ?????? ?????????
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //csrf(Cross-site Request Forgery) - ???????????? ?????? ??????, ??? ????????????????????? ???????????? ?????????, ???????????? ?????????????????? ??????
        //???????????? ????????? ???????????? ???????????? ???????????? ????????? ??????(??????,??????,?????????)??? ?????? ??????????????? ??????????????? ?????? ??????
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

    //???????????? ????????? ????????? security??? ????????? ??? ??? ??????


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

