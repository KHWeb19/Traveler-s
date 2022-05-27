package com.example.demo.service.member;

import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;
import com.example.demo.service.member.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        user.getRoles().add(role);
        userRepository.save(user);
    }

}
