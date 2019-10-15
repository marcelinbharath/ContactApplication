package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserUpdateDao {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDao = ctx.getBean(UserDAO.class);
		// User details will be taken from User-Reg-Form
		User u = new User();
		u.setUserId(5);
		u.setName("Amit Sinha");
		u.setPhone("777777777");
		u.setEmail("amit.sinha@ezeo.com");
		u.setAddress("Mumbai, MS");
		u.setLoginName("amita");
		u.setPassword("amit123");
		u.setRole(1); //Admin
		u.setLoginStatus(1); //Active state
		
		userDao.update(u);
		System.out.println("--------Data Updated---------");
	}

}
