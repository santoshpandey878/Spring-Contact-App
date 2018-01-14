package com.youtube.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.youtube.dao","com.youtube.services"})
public class SpringRootConfig {

	//TODO:Services,DAO,DataSource,Email Sender or some other business layer bean
	
	@Bean
	public BasicDataSource getDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/contactappdb?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("password");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
	
}