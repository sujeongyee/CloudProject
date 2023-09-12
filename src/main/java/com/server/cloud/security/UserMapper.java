package com.server.cloud.security;
import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.UserVO;


@Mapper
public interface UserMapper {

	
	//가입

	public UserVO login(String username);
}
