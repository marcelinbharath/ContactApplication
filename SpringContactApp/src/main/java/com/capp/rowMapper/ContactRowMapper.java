package com.capp.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {
	
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c = new Contact();
		c.setUserId(rs.getInt("userId"));
		c.setContactId(rs.getInt("contactId"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setRemark(rs.getString("remark"));
		c.setPhone(rs.getString("phone"));
		return c;
	}
}
