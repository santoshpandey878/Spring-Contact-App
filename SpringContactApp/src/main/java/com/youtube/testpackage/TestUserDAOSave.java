package com.youtube.testpackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		u.setName("Prakash");
		u.setPhone("486884868");
		u.setEmail("prakash@gmail.com");
		u.setAddress("mohali");
		u.setLoginName("prakash");
		u.setPassword("prakash");
		u.setRole(1); // Admin Role
		u.setLoginStatus(1); // Active
		userDAO.save(u);
		System.out.println("------ Data Saved -------");
	}

}
