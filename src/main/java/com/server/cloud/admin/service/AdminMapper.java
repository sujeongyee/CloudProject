package com.server.cloud.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.server.cloud.command.EngineerVO;


@Mapper
public interface AdminMapper {

	//회원관리 - 엔지니어
	public List<EngineerVO> adEngineerList(EngineerVO engineerVO);
		
	
	
	
	
	
	
	
}
