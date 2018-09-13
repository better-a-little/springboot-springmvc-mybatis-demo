package com.zc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zc.mapper.UserMapper;
import com.zc.pojo.User;
import com.zc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return userMapper.findUserByUsernameAndPassword(username, password);
	}

}
