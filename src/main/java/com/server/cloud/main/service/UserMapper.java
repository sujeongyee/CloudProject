package com.server.cloud.main.service;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.CusVO;


@Mapper
public interface UserMapper {

	void singIn(CusVO vo);

	String idCheck(String string);

	
	
	
}
