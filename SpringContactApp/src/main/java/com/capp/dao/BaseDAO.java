package com.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

// NOTE: Do not use @Repository or @Service or @Component annotation
public abstract class BaseDAO extends NamedParameterJdbcDaoSupport {
	
	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
	}

}
