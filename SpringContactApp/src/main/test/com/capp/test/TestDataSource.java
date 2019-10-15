package com.capp.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.capp.config.SpringRootConfig;

public class TestDataSource {

	public static void main(String[] args) {

		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		
		String sql = "INSERT INTO user ( `name`, `phone`, `email`, `address`, `loginName`, `password`) values (?,?,?,?,?,?)";
		
		Object[] param = new Object[] {"Vichu", "6767676", "abc@gmail.com", "Coimbatore", "vichu", "123"};
		
		jt.update(sql, param);
		System.out.println("-------SQL executed--------------");
	}

}
