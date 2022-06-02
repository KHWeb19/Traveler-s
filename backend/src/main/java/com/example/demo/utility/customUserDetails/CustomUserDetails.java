package com.example.demo.utility.customUserDetails;

import com.example.demo.entity.member.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//security가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만들어 준다 (Security ContextHolder)
//오브젝트 타입 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 됨
// User 오브젝트타입 => UserDetails 타입 객체
//기본 login 회원 정보는 UserDetails에 들어가고 OAuth login 정보는 OAuth2User 객체에 정보가 들어감
// 그래서 커스텀 유저 디테일에 두개를 implements해서 어떤 로그인이든 커스텀유저디테일로 정보를 가져 올 수 있도록 함
@Data
public class CustomUserDetails implements UserDetails, OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    public CustomUserDetails(User user){
        this.user = user;
    }

    public CustomUserDetails(User user, Map<String, Object> attributes){
        this.user = user;
        this.attributes = attributes;
    }
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //해당 User의 권한을 리턴하는 곳
    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_"+r))
                .collect(Collectors.toSet());
    }
    //password 리턴
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    //username 리턴
    @Override
    public String getUsername() {
        return user.getEmail();
    }
    //계정만료
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //계정잠겼니
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //비밀번호 사용안한지 오래 된건 아니니 -> 아니요(true)
    @Override
    public boolean isCredentialsNonExpired() {
        //if 우리사이트 회원이 1년동안 로그인 안하면 휴명계전 전환
        //현재시간 - 로그인시간 -> 1년 초과 return false 이런식으로 하면 된다고 함
        return true;
    }
    //계정이 활성화 되어있니
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
