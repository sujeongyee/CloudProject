package com.server.cloud.main.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.CusVO;
import com.server.cloud.s3.FileVO;

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

	@Override
	public void updateInfo(CusVO vo) {
		userMapper.updateInfo(vo);
		
	}


	@Override
	public void setPoto(FileVO file) {
		// TODO Auto-generated method stub
		userMapper.setPoto(file);
	}



}
