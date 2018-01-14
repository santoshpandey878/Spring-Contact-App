package com.youtube.testpackage;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;

public class TestUserDAOFindAllRecord {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		List<User> users = userDAO.findAll();
		for(User u : users){
			System.out.println(u.getUserId() + "    "+ u.getName() + "    "+ u.getEmail());
		}
		
		
	}

}
