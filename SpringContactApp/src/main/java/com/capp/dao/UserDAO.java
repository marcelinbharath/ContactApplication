package com.capp.dao;

import java.util.List;

import com.capp.domain.User;

public interface UserDAO {
		public void save(User user);
		public void update(User user);
		public void delete(User user);
		public void delete(Integer userId);
		public User findById(Integer userId);
		public List<User> findAll();
		public User findUserByUsernameAndPwd(String userName, String pwd);
		public List<User> findByProperty(String propName, Object propValue);
}
