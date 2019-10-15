package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.User;
import com.capp.exception.UserBlockedException;
import com.capp.rowMapper.UserRowMapper;
import com.capp.service.UserService;

@Repository
public class UserDaoImpl extends BaseDAO implements UserDAO {

	
	public void save(User user) {

		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ " values(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)"; 
		Map<String, Object> m = new HashMap<String, Object>();
		
		m.put("name",  user.getName());
		m.put("phone",  user.getPhone());
		m.put("email",  user.getEmail());
		m.put("address",  user.getAddress());
		m.put("loginName",  user.getLoginName());
		m.put("password",  user.getPassword());
		m.put("role",  Integer.toString(user.getRole()));
		m.put("loginStatus",  user.getLoginStatus());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps,kh);
		Integer userId = kh.getKey().intValue();
		user.setUserId(userId);
	
	}

	public void update(User user) {
		String sql = "update user "
				+ "set name=:name,"
				+ "phone=:phone,"
				+ "email=:email,"
				+ "address=:address,"
				+ "role=:role,"
				+ "loginStatus=:loginStatus"
				+ " where userId=:userId";
		Map<String, Object> m = new HashMap<String, Object>();
		
		m.put("name",  user.getName());
		m.put("phone",  user.getPhone());
		m.put("email",  user.getEmail());
		m.put("address",  user.getAddress());
		m.put("role",  Integer.toString(user.getRole()));
		m.put("loginStatus",  user.getLoginStatus());
		m.put("userId", user.getUserId());
		getNamedParameterJdbcTemplate().update(sql, m);
	
	}
	
	public void delete(User user) {
		this.delete(user.getUserId());
		
	}

	public void delete(Integer userId) {
		String sql = "delete from user where userid=?";
		getJdbcTemplate().update(sql, userId);
	}

	public User findById(Integer userId) {
		String sql = "select userId, name, phone, email, address, loginName, role, loginStatus "+
						" from user where userid = ?";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		return user;
	}

	public List<User> findAll() {
		String sql = "select userId, name, phone, email, address, loginName, role, loginStatus "+
				" from user order by userId ";
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
		return users;
	}
	
    public User findUserByUsernameAndPwd(String userName, String pwd) {
    	String sql = "select userId, name, phone, email, address, role, loginStatus, loginName "
				+ "from user where loginName=:ln and password=:pwd";
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("ln", userName);
		m.put("pwd", pwd);
		
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			return u;
		} catch(EmptyResultDataAccessException ex) {
			return null;
		}
    }
	
	public List<User> findByProperty(String propName, Object propValue) {
		String sql = "select userId, name, phone, email, address, loginName, role, loginStatus "+
				" from user where "+ propName+"=?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
		
	}

}
