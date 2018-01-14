package com.youtube.testpackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youtube.config.SpringRootConfig;
import com.youtube.dao.UserDAO;
import com.youtube.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		userDAO.delete(6);
		System.out.println("------ Data Deleted -------");
	}

}
