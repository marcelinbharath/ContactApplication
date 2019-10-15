package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		
		System.out.println("--------User Find By Property---------");
		
		List<User> users1 = userDao.findByProperty("role", 2);
		for (User k: users1) {
			System.out.println(k.getUserId()+"  "+ k.getName()+"  " + k.getEmail());
		}
	}
}
