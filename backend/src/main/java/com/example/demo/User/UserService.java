package com.example.demo.User;

import com.example.demo.Role.Role;

import java.util.List;

public interface UserService {
    List<User> listAll();
    void addUser(User user);
    void addRoleToUser(User user, Role role);
}
