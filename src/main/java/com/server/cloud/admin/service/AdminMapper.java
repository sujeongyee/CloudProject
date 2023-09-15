package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

@Mapper
public interface AdminMapper {

	int getTotal();

	List<NoticeVO> getList(Criteria cri);
	
	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);

	//회원관리 - 기업
	public List<CusVO> adClientList(CusVO cusVO);

	
	
}
