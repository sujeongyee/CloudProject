package com.server.cloud.client.service;

import java.util.ArrayList;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.ProjectListVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ServerVO;

import com.server.cloud.command.ClientVO;
import com.server.cloud.command.CommentVO;
import com.server.cloud.command.ProjectListVO;

@Mapper
public interface ClientMapper {
	

	//클라이언트 정보 불러오기
	//public ArrayList<CusVO> getCusList(CusVO cusVO);
	public ArrayList<CusVO> getCusList(String cus_id);
	
	//프로젝트, 서버 정보 입력
//	public int applyForm(@Param("proVO") ProjectInfoVO proVO, 
//						 @Param("serverList") ArrayList<ServerVO> serverList);
	
	public void proApplyForm(ProjectInfoVO proVO);
	public void serverApplyForm(ArrayList<ServerVO> serverList);
	
	//프로젝트 리스트 
	public ArrayList<ProjectInfoVO> getProList(String cus_id);
	
	//프로젝트 세부사항 
	public ArrayList<ProjectDetailVO> projectDetail(String pro_id); 
	

	   //작업 내역 리스트
	   public ArrayList<ProjectListVO> projectDetailList();
	   public ArrayList<ProjectListVO> projectDetailChart();
	   
	   
	   
	
	


}
