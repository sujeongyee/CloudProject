package com.server.cloud.main.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.server.cloud.command.CusVO;




public interface UserService {

	void singIn(CusVO vo);

	String idCheck(String string);

	
	
}
