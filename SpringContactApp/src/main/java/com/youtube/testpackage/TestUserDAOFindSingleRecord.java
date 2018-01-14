package com.youtube.testpackage;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;

public class TestUserDAOFindSingleRecord {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = userDAO.findById(4);
		System.out.println("------ Data fetched -------");
		System.out.println("------ User Details -------");
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		System.out.println(u.getAddress());
	}

}
