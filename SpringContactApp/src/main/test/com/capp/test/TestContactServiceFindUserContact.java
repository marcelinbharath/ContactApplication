package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.domain.Contact;
import com.capp.service.ContactService;

public class TestContactServiceFindUserContact {

	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		ContactService contactService = ctx.getBean(ContactService.class);
		
		List<Contact> contacts = contactService.findUserContact(4, "Priya");
		
		for(Contact c : contacts) {
			System.out.println(c.getUserId() +",  "+ c.getName()+",  "+ c.getEmail());
		}
		
		System.out.println("-------- Found User Contacts Successfullys!!! ---------");
		
	}
}
