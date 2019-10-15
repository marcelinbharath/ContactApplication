package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;

public class TestUserDAODelete {

	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		userDao.delete(2);
		System.out.println("--------Data Deleted---------");
	}

}
