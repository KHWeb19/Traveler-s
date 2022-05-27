package com.example.demo.service.member;

import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    void addUser(User user);
    void addRoleToUser(User user, Role role);
}
