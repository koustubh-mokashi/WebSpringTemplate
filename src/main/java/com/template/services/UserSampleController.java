package com.template.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.template.bo.UserBO;
import com.template.vo.UserVO;

@RestController
@RequestMapping("users")
public class UserSampleController {
	
	@Autowired
	UserBO userBO;

	@RequestMapping(method = RequestMethod.GET, value="/{userId}", produces={"application/json"})
	public ResponseEntity<UserVO> getUser(@PathVariable("userId") int userId) {
		 UserVO userVOResponse = userBO.getUser(userId);
		 return new ResponseEntity<UserVO>(userVOResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserVO> saveUser(@RequestBody UserVO userVO) {
		UserVO userVOResponse = userBO.saveUser(userVO);
		return new ResponseEntity<UserVO>(userVOResponse, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserVO> updateUser(@RequestBody UserVO userVO) {
		UserVO userVOResponse = userBO.updateUser(userVO);
		return new ResponseEntity<UserVO>(userVOResponse, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{userId}", produces = "application/json")
	public ResponseEntity<UserVO> removeUser(@PathVariable("userId") String userId) {
		UserVO userVOResponse = userBO.removeUser(userId);
		return new ResponseEntity<UserVO>(userVOResponse, HttpStatus.OK);
	}
	
	public UserBO getUserbo() {
		return userBO;
	}

	public void setUserbo(UserBO userBO) {
		this.userBO = userBO;
	}
	
}
