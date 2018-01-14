package com.youtube.testpackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.domain.User;
import com.youtube.services.UserService;

public class TestUserServiceSave {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User u = new User();
		u.setName("vibhash");
		u.setPhone("486884868");
		u.setEmail("prakash@gmail.com");
		u.setAddress("mohali");
		u.setLoginName("vibhash");
		u.setPassword("vibhash");
		u.setRole(userService.ROLE_ADMIN); // Admin Role
		u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE); // Active
		userService.register(u);
		System.out.println("------ User Registered succesfully -------");
	}

}
