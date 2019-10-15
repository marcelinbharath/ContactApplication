package com.capp.dao;

import java.util.List;

import com.capp.domain.Contact;

public interface ContactDAO {

	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactId);
	public Contact findById(Integer contactId);
	public List<Contact>  findUserContact(Integer userId);
	public List<Contact> findAllContacts();
	public List<Contact> ContactFindByProperty(String propName, Object propValue);

}
