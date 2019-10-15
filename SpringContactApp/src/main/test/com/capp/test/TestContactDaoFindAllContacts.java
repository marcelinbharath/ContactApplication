package com.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;

public class TestContactDaoFindAllContacts {

	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		ContactDAO contactDao = ctx.getBean(ContactDAO.class);
		List<Contact> cts = contactDao.findAllContacts();
		System.out.println("--------Contact Details---------");
		
		for (Contact c : cts) {
			System.out.println(c.getUserId()+"  "+ c.getName()+"  " + c.getEmail()+ c.getRemark());
		}
	}

}
