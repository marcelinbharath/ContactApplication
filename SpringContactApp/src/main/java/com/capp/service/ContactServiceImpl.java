package com.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;
import com.capp.rowMapper.ContactRowMapper;

import comm.capp.util.StringUtility;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {
	
	@Autowired
	ContactDAO contactDAO;
	
	public void save(Contact c) {
		contactDAO.save(c);
	}
	
	public void update(Contact c) {
		contactDAO.update(c);
	}
	
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
	}

	public void delete(Integer[] contactId) {
		String ids= StringUtility.toCommaSeparatedString(contactId);
		String sql = "Delete from contact where contactId in (" + ids + ")";
		getJdbcTemplate().update(sql);
	}

	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.ContactFindByProperty("userId", userId);
	}

	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "select contactId, userId, name, phone, email, address, remark " + 
				" from contact where userid = ? AND (name like '%" + txt + "%' OR address like '%" + txt + "%' OR phone like '%" + txt + "%' OR  remark like '%" + txt + "%')";
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
		return contacts;
	}

	public Contact findById(Integer contactId) {
		return contactDAO.findById(contactId);
		
	}

}
