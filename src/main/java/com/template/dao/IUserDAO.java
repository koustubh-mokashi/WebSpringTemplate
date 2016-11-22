package com.template.dao;

import com.template.model.User;

public interface IUserDAO {

	public User getUser(int userId);

	public User saveUser(User user);

	public User updateUser(User user);

	public User removeUser(String userId);
}
