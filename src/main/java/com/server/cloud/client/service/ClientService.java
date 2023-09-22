package com.server.cloud.client.service;

import java.util.ArrayList;

import com.server.cloud.command.CusVO;
import com.server.cloud.command.InsRequestVO;
import com.server.cloud.command.ProjectInfoVO;
import com.server.cloud.command.ProjectListVO;
import com.server.cloud.command.ProjectDetailVO;
import com.server.cloud.command.ServerVO;

public interface ClientService {
	
	//클라이언트 정보 리스트 
	public ArrayList<CusVO> getCusList(String cus_id);
	
	//프로젝트 정보 입력
	public void proApplyForm(ProjectInfoVO proVO);
	
	//서버 정보 입력 
	public void serverApplyForm(ArrayList<ServerVO> serverList);
	
	//프로젝트 리스트 
	public ArrayList<ProjectInfoVO> getProList(String cus_id);

	//프로젝트 세부사항 
	public ArrayList<ProjectDetailVO> projectDetail(String pro_id); 
	
	//점검요청 
	public void insRequestForm(InsRequestVO insReVO);
	
	
	
	//작업내역 목록 
	public ArrayList<ProjectListVO> projectDetailList();
	
	//작업내역 로그 
	public ArrayList<ProjectListVO> projectDetailChart();

	

}
