package com.zc.service;

import com.zc.pojo.User;

public interface UserService {
	
	User findUserByUsernameAndPassword(String username, String password);

}
