package com.youtube.testpackage;

import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.youtube.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String query = "insert into user(`name`, `phone`, `email`, `address`, `loginName`, `password`) values(?,?,?,?,?,?)";
		Object[] param = new Object[]{"beenu","9303580884","vikram@gm.com","bhopal","beenu","123"};
		jt.update(query, param);
		System.out.println("sql executed");

	}

}
