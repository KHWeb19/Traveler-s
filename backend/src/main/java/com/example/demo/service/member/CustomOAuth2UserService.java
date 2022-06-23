package com.example.demo.service.member;

import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;

import com.example.demo.utility.customUserDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /*@Autowired
    HttpSession httpSession;*/

    //userRequest는 AccessToken정보까지 들어있음
    //그 정보로 loadUser함수 호출해서 -> 회원프로필을 받아와야함
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        //userRequest 정보 가져옴
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        log.info(userRequest.getAccessToken().toString());
        log.info(userRequest.toString());


        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        /*String usernameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                                                .getUserInfoEndpoint().getUserNameAttributeName();*/

        String email;
        String name;

        Map<String, Object> response = oAuth2User.getAttributes();
        //registrationId로 구글인지 네이버 로그인인지 구별 가능
        if (registrationId.equals("naver")){
            //naver는 attiribute의 response안에 정보가 들어있다
            Map<String, Object> hash = (Map<String, Object>) response.get("response");
            email = (String) hash.get("email");
            name  = (String) hash.get("name");
        } else if (registrationId.equals("google")){
            email = (String) response.get("email");
            name  = (String) response.get("name");
        } else {
            throw new OAuth2AuthenticationException("INVALID AUTHENTICATION");
        }
        //email 중복 찾기
        User userEntity;

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(!optionalUser.isEmpty()){
            //로그인 한 적이 있는 경우
            userEntity = optionalUser.get();
        }else{
            //로그인한적이 없는 경우
            //setter 대신 builder 고려
            //비밀번호는 어떻게 해야하는지 강사님한테 여쭤보기 -> 이메일,이름기반으로 uuid?
            //전화번호는 본인인증 후 db에 넣는것으로 하기
            //이름은 예약할때 변경할 수 있도록하기
            UUID uuid = UUID.randomUUID();

            String password = name + uuid + email;
            String encodedPassword = passwordEncoder.encode(password);

            Role role = new Role("ROLE_USER");
            List<Role> roleList= new ArrayList<>();
            roleList.add(role);
            //전화번호는 마이페이지나/결제할 때 넣도록 해야할 듯
            userEntity = User.builder()
                    .email(email)
                    .name(name)
                    .password(encodedPassword)
                    .profile_path("default.png")
                    .roles(roleList).build();
            /*userEntity.setEmail(email);
            userEntity.setName(name);
            userEntity.setPassword(encodedPassword);
            userEntity.getRoles().add(new Role("ROLE_USER"));*/
            userRepository.save(userEntity);

        }

        //return 되는 이것이 Authentication 객체에 저장되고 세션 정보로 들어갈것
        return new CustomUserDetails(userEntity, response);

        /*return new DefaultOAuth2User(user.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).collect(Collectors.toSet()),
            oAuth2User.getAttributes(),
            usernameAttributeName);*/
    }
}