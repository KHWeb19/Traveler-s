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
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(s);
        if (user.isEmpty())
            throw new UsernameNotFoundException("USERNAME NOT FOUND");
        UserDetails customUserDetails = new CustomUserDetails(user.get());
        return customUserDetails;
    }

}
