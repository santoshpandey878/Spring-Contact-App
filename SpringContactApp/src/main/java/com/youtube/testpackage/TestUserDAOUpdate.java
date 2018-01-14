package com.youtube.testpackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		// TODO: user update data taken from profile update page
		User u = new User();
		u.setName("Prakash pandey");
		u.setPhone("486884868");
		u.setEmail("prakash@gmail.com");
		u.setAddress("mohali, chandigarh");
		u.setRole(1); // Admin Role
		u.setLoginStatus(1); // Active
		u.setUserId(6);
		userDAO.update(u);
		System.out.println("------ Data Updated -------");
	}

}
