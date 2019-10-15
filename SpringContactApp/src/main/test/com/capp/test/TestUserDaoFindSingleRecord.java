package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoFindSingleRecord {
	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		User u = userDao.findById(3);
		System.out.println("--------User Details---------");
		System.out.println(u.getUserId());
		System.out.println(u.getName());
		System.out.println(u.getPhone());
		System.out.println(u.getEmail());
	}
}
