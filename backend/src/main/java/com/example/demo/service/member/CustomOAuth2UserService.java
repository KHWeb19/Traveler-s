package com.example.demo.service.member;


import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession httpSession;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String usernameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        String email;
        Map<String, Object> response = oAuth2User.getAttributes();

        if (registrationId.equals("naver")){
            Map<String, Object> hash = (Map<String, Object>) response.get("response");
            email = (String) hash.get("email");
        } else if (registrationId.equals("google")){
            email = (String) response.get("email");
        } else {
            throw new OAuth2AuthenticationException("INVALID AUTHENTICATION");
        }

        User user;
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()){
            user = optionalUser.get();
        }else{
            user = new User();
            user.setEmail(email);
            user.getRoles().add(new Role("ROLE_USER"));
        }
        httpSession.setAttribute("user", user);

        return new DefaultOAuth2User(user.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toSet()),
            oAuth2User.getAttributes(),
            usernameAttributeName);
    }
}
