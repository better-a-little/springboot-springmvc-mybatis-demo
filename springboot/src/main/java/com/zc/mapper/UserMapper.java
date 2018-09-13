package com.zc.mapper;

import org.apache.ibatis.annotations.Param;

import com.zc.pojo.User;

public interface UserMapper {
	
	User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
