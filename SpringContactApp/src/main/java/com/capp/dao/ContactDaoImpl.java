package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.Contact;
import com.capp.rowMapper.ContactRowMapper;

@Repository
public class ContactDaoImpl extends BaseDAO implements ContactDAO {
	
	public void save(Contact c) {

		String sql = "insert into contact( userId, name, phone, email, address, remark) values "+
				"(:userId, :name, :phone, :email, :address, :remark)";
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		c.setContactId(kh.getKey().intValue());
	}

	public void update(Contact c) {
		
		String sql = "update contact "
				+ "set name=:name,"
				+ "phone=:phone,"
				+ "email=:email,"
				+ "address=:address,"
				+ "remark=:remark"
				+ " where contactId=:contactId";
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("contactId", c.getContactId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());	
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	public void delete(Contact c) {
		this.delete(c.getContactId());
	}

	public void delete(Integer contactId) {
		String sql = "delete from contact where contactId=?";
		getJdbcTemplate().update(sql, contactId);
	}

	
	public List<Contact> findUserContact(Integer userId) {
		List<Contact> contacts = this.ContactFindByProperty("userid", userId);
		return contacts;
	}

	
	public List<Contact> findAllContacts() {
		String sql = "select contactId, userId, name, phone, email, address, remark " + 
									" from contact order by contactId";
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper());
		return contacts;
	}
	
	public List<Contact> ContactFindByProperty(String propName, Object propValue) {
		String sql = "select contactId, userId, name, phone, email, address, remark "+
				" from contact where "+ propName+"=?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
	}

	public Contact findById(Integer contactId) {
		String sql = "select contactId, userId, name, phone, email, address, remark "+
				" from contact where contactId=?";
		Contact contact = (Contact) getJdbcTemplate().queryForObject(sql, new Object[] {contactId}, new ContactRowMapper());
		return contact;
	}

}
