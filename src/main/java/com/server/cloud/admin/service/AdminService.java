package com.server.cloud.admin.service;

import java.util.List;

import com.server.cloud.command.EngineerVO;

public interface AdminService {

	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);
}
