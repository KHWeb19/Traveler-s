package com.example.demo.User;

import com.example.demo.Role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String index(){

        return "index page";
    }

    @GetMapping("/listall")
    public List<User> login(){
        return userService.listAll();
    }

    @PostMapping("/register")
    public void register(){
        User user = new User("admin", "admin@gmail.com", "password");
        Role role = new Role("ADMIN");
        userService.addUser(user);
        userService.addRoleToUser(user, role);
    }

}
