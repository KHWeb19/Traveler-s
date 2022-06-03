package com.example.demo.utility.customUserDetails;

import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    //user 정보 가져와서 db랑 user정보 맞는지 확인하는 부분
    //시큐리티 설정에서 loginProcessingUrl("/login")
    //login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행
    //UesrDetails -> security session > Authentication > UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        if (user.isEmpty())
            throw new UsernameNotFoundException("USERNAME NOT FOUND");

        UserDetails customUserDetails = new CustomUserDetails(user.get());
        //return 되면 Authentication으로 들어가고 Security session으로 들어감
        return customUserDetails;
    }

}
