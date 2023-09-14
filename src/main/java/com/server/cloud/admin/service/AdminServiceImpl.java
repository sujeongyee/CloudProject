package com.server.cloud.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.cloud.command.EngineerVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	//회원관리 - 엔지니어
	@Override
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO) {
		return adminMapper.adEngineerList(engineerVO);
	}
	
}
