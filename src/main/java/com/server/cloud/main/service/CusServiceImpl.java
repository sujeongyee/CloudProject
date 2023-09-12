package com.server.cloud.main.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CusVO;

@Service
public class CusServiceImpl implements CusService{

	
	@Autowired
	private CusMapper userMapper;
	
	@Override
	public void singIn(CusVO vo) {

		userMapper.singIn(vo);
		
	}

	@Override
	public CusVO idCheck(String string) {
		// TODO Auto-generated method stub
		return userMapper.idCheck(string);
	}



}
