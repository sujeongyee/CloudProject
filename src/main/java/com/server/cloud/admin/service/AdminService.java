package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

public interface AdminService {

	int getTotal();

	List<NoticeVO>  getList(Criteria cri);


	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);	






}
