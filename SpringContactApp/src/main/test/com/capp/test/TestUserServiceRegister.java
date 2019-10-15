package com.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.domain.User;
import com.capp.service.UserService;

public class TestUserServiceRegister {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserService userService = ctx.getBean(UserService.class);
		
		// User details will be taken from User-Reg-Form
		User u = new User();
		u.setName("Nitin");
		u.setPhone("555555555");
		u.setEmail("nitin@ezeo.com");
		u.setAddress("Mumbai");
		u.setLoginName("nitin");
		u.setPassword("nitin123");
		u.setRole(userService.ROLE_USER); 
		u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE); //Active state
		
		userService.register(u);
		
		System.out.println("--------User Registered Successfully!!! ---------");
		
	}

}
