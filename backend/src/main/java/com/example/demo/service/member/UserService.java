package com.example.demo.service.member;

import com.example.demo.dto.member.MemberRequest;
import com.example.demo.dto.member.MobileRequest;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listAll();
    void addUser(MemberRequest userRequest);
    void addRoleToUser(User user, Role role);
    void cellPhoneCheck(String phoneNumber,String sendMsg);
    Optional<User> findByEmail(String email);
    String emailDuplicationCheck(String email);
    String mobileDuplicationCheck(MobileRequest mobile);
    Optional<User> findByEmailWithHotels(String email);

    void saveUser(User user);
}
