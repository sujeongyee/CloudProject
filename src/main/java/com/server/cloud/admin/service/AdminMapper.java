package com.server.cloud.admin.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.server.cloud.command.CsVO;

import com.server.cloud.command.CusVO;

import com.server.cloud.command.EngineerVO;
import com.server.cloud.command.NoticeVO;
import com.server.cloud.pagenation.Criteria;

@Mapper
public interface AdminMapper {

	int getTotal(String role);

	List<NoticeVO> getList(Criteria cri);

	
	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);


	List<CsVO> csList(Criteria cri);

	int csTotal();

	void csUpdate(CsVO vo);

	//회원관리 - 기업
	public List<CusVO> adClientList(CusVO cusVO);

	int csUserTotal(String cs_writer);

	List<CsVO> csEnList(Criteria cri);

	EngineerVO engGetinfo(String cs_writer);

	int csEnTotal(Criteria cri);

	List<CsVO> csEnListMy(Criteria cri);

	List<CsVO> csEnLeaderList(Criteria cri);

	List<CsVO> csEnLeaderListMy(Criteria cri);

}
