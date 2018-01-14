package com.youtube.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
//NOTE: do not use @repository or service or component
public class BaseDAO extends NamedParameterJdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource ds){
		super.setDataSource(ds);
	}
	
}
