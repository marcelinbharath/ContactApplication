package com.capp.service;

import java.util.List;

import com.capp.domain.Contact;

public interface ContactService {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void delete(Integer[] contactId);
	public Contact findById(Integer contactId);
	/**
	 * This method returns all user contact (user who is logged in)
	 * @param userId
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId);
	
	/**
	 * This method search contact for user based on given free text criteria.
	 * @param userId user who is logged in
	 * @param txt criteria used to search  -  free text search criteria.
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId, String txt);
}
