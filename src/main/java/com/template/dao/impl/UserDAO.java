package com.template.dao.impl;

import org.springframework.stereotype.Repository;

import com.template.dao.IUserDAO;
import com.template.model.User;

@Repository("userDAO")
public class UserDAO extends BaseDAO<User> implements IUserDAO {

	public User getUser(int userId) {
		User user = (User) getSession().get(User.class, userId);
		return user;
	}

	public User saveUser(User user) {
		persist(user);
		return user;
	}

	public User updateUser(User user) {
		update(user);
		return user;
	}

	public User removeUser(String userId) {
		return null;
	}

}
