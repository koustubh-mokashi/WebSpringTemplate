package com.template.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.template.dao.IUserDAO;
import com.template.exception.UserNotFoundException;
import com.template.model.User;
import com.template.vo.UserVO;

@Component
public class UserBO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserBO.class);

	@Autowired
	private IUserDAO userDAO;

	@Transactional
	public UserVO getUser(int userId) {
		LOGGER.info("Inside getUser() method");
		UserVO userVO = new UserVO();
		User user = userDAO.getUser(userId);
		if (user != null) {
			BeanUtils.copyProperties(user, userVO);
			return userVO;
		}
		throw new UserNotFoundException(userId);
	}

	@Transactional
	public UserVO saveUser(UserVO userVO) {
		LOGGER.info("Inside saveUser() method");
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		User userResponse = userDAO.saveUser(user);
		userVO.setId(userResponse.getId());
		return userVO;
	}

	@Transactional
	public UserVO updateUser(UserVO userVO) {
		LOGGER.info("Inside updateUser() method");
		User user = userDAO.getUser(userVO.getId());
		if (user == null) {
			throw new UserNotFoundException(userVO.getId());
		}
		BeanUtils.copyProperties(userVO, user);
		User userResponse = userDAO.updateUser(user);
		userVO.setId(userResponse.getId());
		return userVO;
	}

	@Transactional
	public UserVO removeUser(String userId) {
		LOGGER.info("Inside removeUser() method");
		UserVO userVO = new UserVO();
		User userResponse = userDAO.removeUser(userId);
		userVO.setId(userResponse.getId());
		return userVO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
