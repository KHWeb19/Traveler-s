package com.example.demo;

import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.service.member.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	/*@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		User user = new User("admin", "admin@gmail.com", "password");
		user.getRoles().add(new Role("ROLE_USER"));
		userService.addUser(user);
	}*/

}
