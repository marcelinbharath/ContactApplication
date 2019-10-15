package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDaoFindAll {
	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		List<User> users = userDao.findAll();
		System.out.println("--------User Details---------");
		
		for (User u: users) {
			System.out.println(u.getUserId()+"  "+ u.getName()+"  " + u.getEmail());
		}
	}
}
